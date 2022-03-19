package andersen.randomize.service;

import andersen.randomize.dao.LessonRepository;
import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import andersen.randomize.entity.Team;
import andersen.randomize.service.wrapper.StudentListWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    private List<Student> askList;
    private List<Student> answerList;

    public StudentServiceImpl(StudentRepository studentRepository, LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    public void getPresentedStudentById(StudentListWrapper studentWrapper) {
        LOGGER.debug("Looking for new players");
        List<Student> studentsOnlyWithId = studentWrapper.getStudents().stream().filter(s -> s.getId() > 0).collect(Collectors.toList());
        List<Student> presentStudent = new ArrayList<>();
        Lesson lesson = studentWrapper.getLesson();
        for (int i = 0; i < studentsOnlyWithId.size(); i++) {
            presentStudent.add(studentRepository.findById(studentsOnlyWithId.get(i).getId()).orElse(new Student()));
            lesson.addStudent(presentStudent.get(i));
        }
        lessonRepository.save(lesson);
        askList = fillList(presentStudent);
        answerList = fillList(presentStudent);
    }

    @Override
    public List<Student> findRandomPlayers() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        LOGGER.debug("Start finding random players");
        if (isBothListEmpty()) {
            return Collections.emptyList();
        }
        int askNumber = random.nextInt(askList.size());
        int answerNumber = random.nextInt(answerList.size());
        Student ask = askList.get(askNumber);
        Student answer = answerList.get(answerNumber);

        boolean ifOnlyOneTeam = false;
        while (ask.getId() == answer.getId() || ask.getTeam().getId() == answer.getTeam().getId()) {                    //if id and teams not equals    -> exit the loop
            if (askList.size() == 1 && answerList.size() == 1) {                                                        //if there is only one player   -> exit the loop
                break;
            }
            if (ask.getId() == answer.getId()) {
                ask = askList.get(random.nextInt(askList.size()));
                answer = answerList.get(random.nextInt(answerList.size()));
                continue;
            }
            while (ask.getTeam().getId() == answer.getTeam().getId()) {                                                 //if teams the same             -> ask about a count of teams
                if (ifOnlyOneTeam(askList, answerList)) {                                                               //if there is only one team     -> exit the loop
                    ifOnlyOneTeam = true;
                    break;
                }
                ask = askList.get(random.nextInt(askList.size()));
                answer = answerList.get(random.nextInt(answerList.size()));
                if (ask.getId() == answer.getId()) break;
            }
            if (ifOnlyOneTeam) break;
        }
        List<Student> outputTwoStudents = new ArrayList<>(); //return two students to front
        outputTwoStudents.add(ask);
        outputTwoStudents.add(answer);
        LOGGER.debug("Student {} asks student {}", ask.getName(), answer.getName());

        askList.remove(ask);
        answerList.remove(answer);

        return outputTwoStudents;
    }

    @Override
    public void changeStudentGrade(StudentListWrapper studentsGradeWrapper) {
        LOGGER.debug("Change student's garde");
        Student askStudent = studentsGradeWrapper.getStudents().get(0);
        Student answerStudent = studentsGradeWrapper.getStudents().get(1);
        askStudent.setScore(askStudent.getScore() + studentsGradeWrapper.getAskGrade());
        answerStudent.setScore(answerStudent.getScore() + studentsGradeWrapper.getAnswerGrade());
        studentRepository.save(askStudent);
        studentRepository.save(answerStudent);
    }

    @Override
    public List<Student> findAllByDate(LocalDate date) {
        return studentRepository.findAllByDate(date);
    }

    /**
     * Check if there aren't other teams
     *
     * @param askList    - ask students
     * @param answerList - answer stidents
     * @return is remained students from one team
     */
    private boolean ifOnlyOneTeam(List<Student> askList, List<Student> answerList) {
        Set<Team> askTeams = new HashSet<>();
        Set<Team> answerTeams = new HashSet<>();
        for (Student askStudent : askList) {
            askTeams.add(askStudent.getTeam());
        }
        for (Student answerStudent : answerList) {
            answerTeams.add(answerStudent.getTeam());
        }
        return askTeams.size() == 1 && answerTeams.size() == 1;
    }

    private List<Student> fillList(List<Student> present) {
        List<Student> newList = new ArrayList<>(present.size());
        newList.addAll(present);
        return newList;
    }

    private boolean isBothListEmpty() {
        return askList.isEmpty() && answerList.isEmpty();
    }

}
