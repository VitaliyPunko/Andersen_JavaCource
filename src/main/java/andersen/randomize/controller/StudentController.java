package andersen.randomize.controller;

import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/findAll")
    Iterable<Student> findAll() {
        return studentRepository.findAll();
    }


}
