package andersen.randomize.service;

import andersen.randomize.entity.Student;
import andersen.randomize.service.wrapper.StudentListWrapper;

import java.util.List;

public interface StudentService {

    void getPresentedStudentById(StudentListWrapper studentWrapper);

    List<Student> findRandomPlayers();

    void changeStudentGrade(StudentListWrapper studentsGradeWrapper);
}
