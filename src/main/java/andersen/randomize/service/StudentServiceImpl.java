package andersen.randomize.service;

import andersen.randomize.dao.LessonRepository;
import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import andersen.randomize.service.wrapper.StudentListWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Student> studentsOnlyWithId = studentWrapper.getStudents().stream().filter(s -> s.getId() > 0).collect(Collectors.toList());
        List<Student> presentStudent = new ArrayList<>();
        Lesson lesson = studentWrapper.getLesson();
        for (int i = 0; i < studentsOnlyWithId.size(); i++) {
            presentStudent.add(studentRepository.findById(studentsOnlyWithId.get(i).getId()).orElse(new Student()));
//            presentStudent.get(i).addLesson(studentWrapper.getLesson());
            lesson.addStudent(presentStudent.get(i));
        }  //save how?
        lessonRepository.save(lesson);
        askList = new ArrayList<>(presentStudent);
        answerList = new ArrayList<>(presentStudent);
    }

    @Override
    public List<Student> findRandomPlayers() {
        if (askList.isEmpty() && answerList.isEmpty()) {
            return Collections.emptyList();
        }
        int askNumber = (int) (Math.random() * askList.size()); //number of ask student from 0 to askList size not inclusive
        int answerNumber = (int) (Math.random() * answerList.size());     //number of ask student from 0 to askList size not inclusive
        Student ask = askList.get(askNumber);
        Student answer = answerList.get(answerNumber);

        //TODO: что делать есть остались из одной команды или лишний студент?
        while (ask.getId() == answer.getId() || ask.getTeam() == answer.getTeam()) {                     //проверяем не совпадают ли студенты
            if (askList.size() == 1 && answerList.size() == 1) {  //если размеры обоих листов = 1, то осталось по одному студенту
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


}
