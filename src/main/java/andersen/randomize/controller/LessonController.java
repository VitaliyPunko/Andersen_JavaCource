package andersen.randomize.controller;

import andersen.randomize.dao.LessonRepository;
import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class LessonController {

    Logger LOGGER = LoggerFactory.getLogger(LessonController.class);

    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;

    public LessonController(LessonRepository lessonRepository, StudentRepository studentRepository) {
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/choseLessonDate")
    String goToChoseLessonDatePage(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "chose_lesson_date";
    }

    @PostMapping("/choseDate")
    String showStudentByDate(@ModelAttribute("lesson") Lesson lesson, Model model) {
        //если нет такой в бд, то создать
        if (lesson.getDate().isBefore(LocalDate.now())) { //проверить now с сегодняшней датой
            //getStudent by Date
            List<Student> students = studentRepository.findAllByDate(lesson.getDate());
            LOGGER.debug("Students are: {} were at date {}", students, lesson.getDate());
            System.out.println(students);
        } else {
            //return all students
            List<Student> students = StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            model.addAttribute("students", students);
        }
        return "list_page";
    }
}
