package andersen.randomize.service;

import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Student;
import andersen.randomize.service.wrapper.StudentListWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getPresentedStudentById(StudentListWrapper studentWrapper) {
        List<Student> studentsOnlyWithId = studentWrapper.getStudents().stream().filter(s -> s.getId() > 0).collect(Collectors.toList());
        List<Student> presentedToday = new ArrayList<>();
        for (Student s : studentsOnlyWithId) {
            presentedToday.add(studentRepository.findById(s.getId()).orElse(new Student()));
        }

        return presentedToday;
    }


}
