package andersen.randomize.service;

import andersen.randomize.entity.Student;
import andersen.randomize.service.wrapper.StudentListWrapper;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    void getPresentedStudentById(StudentListWrapper studentWrapper);

    List<Student> findRandomPlayers() throws NoSuchAlgorithmException;

    void changeStudentGrade(StudentListWrapper studentsGradeWrapper);

    List<Student> findAllByDate(LocalDate date);
}
