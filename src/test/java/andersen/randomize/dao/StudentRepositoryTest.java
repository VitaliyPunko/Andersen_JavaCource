package andersen.randomize.dao;

import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;
    private List<Student> students;

    @AfterEach
    public void teardown() {
        underTest.deleteAll();
    }

    @Test
    void shouldFindStudentsByDate() {
        //given
        Student student1 = new Student(1, "Jaina", 20.0, true);
        Student student2 = new Student(2, "Praudmur", 10.0, false);
        Lesson lesson1 = new Lesson(1, LocalDate.now());
        student1.addLesson(lesson1);
        student2.addLesson(lesson1);
        underTest.save(student1);
        underTest.save(student2);

        //when
        List<Student> studentByDate = underTest.findAllByDate(LocalDate.now());

        //then
        Assertions.assertTrue(studentByDate.size() > 0);
        Assertions.assertEquals(studentByDate.size(), 2);
        Assertions.assertEquals(studentByDate.get(0).getName(), student1.getName());
    }

    @Test
    void shouldNotFindStudentsByDate() {
        //given
        Student student1 = new Student(1, "Jaina", 20.0, true);
        Student student2 = new Student(2, "Praudmur", 10.0, false);
        Lesson lesson1 = new Lesson(1, LocalDate.now());
        student1.addLesson(lesson1);
        student2.addLesson(lesson1);
        underTest.save(student1);
        underTest.save(student2);

        //when
        List<Student> studentByDate = underTest.findAllByDate(LocalDate.now().minusDays(5));

        //then
        Assertions.assertEquals(0, studentByDate.size());
        Assertions.assertTrue(studentByDate.isEmpty());
    }
}