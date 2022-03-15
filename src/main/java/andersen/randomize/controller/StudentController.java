package andersen.randomize.controller;

import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Student;
import andersen.randomize.service.StudentService;
import andersen.randomize.service.wrapper.StudentListWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private static final String redirectStart = "redirect:/start";
    private final StudentService studentService;
    private LocalDate date;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @PostMapping("/presentStudents")
    String getAllPresent(@Valid @ModelAttribute("studentList") StudentListWrapper studentWrapper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "title_page";
        }
        date = studentWrapper.getLesson().getDate();
        studentService.getPresentedStudentById(studentWrapper); //this return rows only with id
        return redirectStart;
    }

    @GetMapping("/start")
    String startGame(Model studentsGradeWrapper) {
        List<Student> players = studentService.findRandomPlayers();
        if (players.isEmpty()) {
            return "redirect:/findAllByDate"; //redirect to list with today's students
        }
        StudentListWrapper listWrapper = new StudentListWrapper();
        listWrapper.setStudents((ArrayList<Student>) players);
        studentsGradeWrapper.addAttribute("studentsGradeWrapper", listWrapper);
        return "random";
    }

    @PostMapping("/estimate")
    String estimateStudent(@ModelAttribute("studentsGradeWrapper") StudentListWrapper studentsGradeWrapper, Model model) {
        studentService.changeStudentGrade(studentsGradeWrapper);
        return redirectStart;
    }

    @GetMapping("/findAllByDate")
    public String findAllByDate(Model model) {
        LOGGER.debug("Find all by date");
        List<Student> studentsByDate = studentService.findAllByDate(date);
        model.addAttribute("studentsByDate", studentsByDate);
        return "presentList";
    }
}
