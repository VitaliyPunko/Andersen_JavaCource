package andersen.randomize.controller;

import andersen.randomize.dao.LessonRepository;
import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import andersen.randomize.entity.dto.LessonDto;
import andersen.randomize.service.LessonMapperImpl;
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
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private static final String REDIRECT_START = "redirect:/start";
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final LessonMapperImpl lessonMapper;

    private LocalDate date;

    public StudentController(StudentService studentService, StudentRepository studentRepository, LessonRepository lessonRepository, LessonMapperImpl lessonMapper) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
    }

    @GetMapping("/choseLessonDate")
    String goToChoseLessonDatePage(Model model) {
        model.addAttribute("lesson", new LessonDto());
        return "chose_lesson_date";
    }

    @PostMapping("/choseDate")
    String showStudentByDate(@Valid @ModelAttribute("lesson") LessonDto lessonDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "chose_lesson_date";
        }
        if (lessonDto.getDate().isBefore(LocalDate.now())) {
            date = lessonDto.getDate();
            return "redirect:/findAllByDate";
        } else {
            Lesson lesson = lessonMapper.toEntity(lessonDto);
            lessonRepository.save(lesson);//create new lesson
            List<Student> students = StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            StudentListWrapper studentWrapper = new StudentListWrapper();
            studentWrapper.setStudents((ArrayList<Student>) students);
            studentWrapper.setLesson(lesson);
            model.addAttribute("wrapper", studentWrapper);
        }
        return "list";
    }

    @GetMapping("/findAllByDate")
    public String findAllByDate(Model model) {
        LOGGER.debug("Find all by date");
        List<Student> studentsByDate = studentService.findAllByDate(date);
        model.addAttribute("studentsByDate", studentsByDate);
        return "presentList";
    }

    @PostMapping("/presentStudents")
    String getAllPresent(@Valid @ModelAttribute("studentList") StudentListWrapper studentWrapper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "title_page";
        }
        date = studentWrapper.getLesson().getDate();
        studentService.getPresentedStudentById(studentWrapper); //this return rows only with id
        return REDIRECT_START;
    }

    @GetMapping("/start")
    String startGame(Model studentsGradeWrapper) throws NoSuchAlgorithmException {
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
    String estimateStudent(@ModelAttribute("studentsGradeWrapper") StudentListWrapper studentsGradeWrapper) {
        studentService.changeStudentGrade(studentsGradeWrapper);
        return REDIRECT_START;
    }
}
