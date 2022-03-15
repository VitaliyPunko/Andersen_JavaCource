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
        //ToDo: make necessary students
        List<Student> studentsOnlyWithId = studentWrapper.getStudents().stream().filter(s -> s.getId() > 0).collect(Collectors.toList());
        List<Student> presentStudent = new ArrayList<>();
        Lesson lesson = studentWrapper.getLesson();
        for (int i = 0; i < studentsOnlyWithId.size(); i++) {
            presentStudent.add(studentRepository.findById(studentsOnlyWithId.get(i).getId()).orElse(new Student()));
            lesson.addStudent(presentStudent.get(i));
        }
        lessonRepository.save(lesson);
        askList = new ArrayList<>(presentStudent);
        answerList = new ArrayList<>(presentStudent);
    }

    @Override
    public List<Student> findRandomPlayers() {
        LOGGER.debug("Start finding random players");
        if (askList.isEmpty() && answerList.isEmpty()) {
            return Collections.emptyList();
        }
        int askNumber = (int) (Math.random() * askList.size()); //number of ask student from 0 to askList size not inclusive
        int answerNumber = (int) (Math.random() * answerList.size());     //number of ask student from 0 to askList size not inclusive
        Student ask = askList.get(askNumber);
        Student answer = answerList.get(answerNumber);

        while (ask.getId() == answer.getId() || ask.getTeam() == answer.getTeam()) {                     //проверяем не совпадают ли студенты
            if (askList.size() == 1 && answerList.size() == 1) {  //если размеры обоих листов = 1, то осталось по одному студенту
                break;
            }
            if (isOneTeam(askList, answerList)) { //if remained students from one team -> ask each other
                break;
            }
            answerNumber = (int) (Math.random() * answerList.size());
            answer = answerList.get(answerNumber);
        }
        List<Student> outputTwoStudents = new ArrayList<>(); //return two students to front
        outputTwoStudents.add(ask);
        outputTwoStudents.add(answer);
        LOGGER.debug("Student {} asks student {}", ask.getName(), answer.getName());

        askList.remove(askNumber);
        answerList.remove(answerNumber);

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
     * Check if students from one team. And if there aren't other teams
     *
     * @param askList    - ask students
     * @param answerList - answer stidents
     * @return is remained students from one team
     */
    private boolean isOneTeam(List<Student> askList, List<Student> answerList) {
        Set<Team> askTeams = new HashSet<>();
        Set<Team> answerTeams = new HashSet<>();
        for (Student askStudent : askList) {
            askTeams.add(askStudent.getTeam());
        }
        for (Student answerStudent : answerList) {
            answerTeams.add(answerStudent.getTeam());
        }
        if (askTeams.size() == 1 && answerTeams.size() == 1) {
            return askTeams.containsAll(answerTeams);
        }
        return false;
    }


}
