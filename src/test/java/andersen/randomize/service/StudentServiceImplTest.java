package andersen.randomize.service;

import andersen.randomize.dao.LessonRepository;
import andersen.randomize.dao.StudentRepository;
import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import andersen.randomize.service.wrapper.StudentListWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {


    @Mock
    private StudentRepository studentRepository;
    @Mock
    private LessonRepository lessonRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentServiceImpl(studentRepository, lessonRepository);
    }

    @Test
    void canSaveLessonInGetPresentedStudentById() {
        //given
        Student student1 = new Student(1, "Jaina", 20.0, true);
        Student student2 = new Student(2, "Praudmur", 10.0, false);
        ArrayList<Student> arrayList = new ArrayList<>(Arrays.asList(student1, student2));
        Lesson lesson = new Lesson(1, LocalDate.now());
        student1.addLesson(lesson);
        student2.addLesson(lesson);
        StudentListWrapper studentListWrapper = new StudentListWrapper(arrayList, lesson);

        //when
        underTest.getPresentedStudentById(studentListWrapper);

        //then
        ArgumentCaptor<Lesson> lessonArgumentCaptor = ArgumentCaptor.forClass(Lesson.class);
        verify(lessonRepository).save(lessonArgumentCaptor.capture());

        Lesson captorLesson = lessonArgumentCaptor.getValue();

        assertThat(captorLesson).isEqualTo(lesson);
    }

    @Test
    void getPresentedStudentById() {
        //given
        Student student1 = new Student(1, "Jaina", 20.0, true);
        Student student2 = new Student(2, "Praudmur", 10.0, false);
        ArrayList<Student> arrayList = new ArrayList<>(Arrays.asList(student1, student2));
        Lesson lesson = new Lesson(1, LocalDate.now());
        student1.addLesson(lesson);
        student2.addLesson(lesson);
        StudentListWrapper studentListWrapper = new StudentListWrapper(arrayList, lesson);

        //when
        underTest.getPresentedStudentById(studentListWrapper);

        //then
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(studentRepository, times(2)).findById(integerArgumentCaptor.capture());

        Integer captorInteger = integerArgumentCaptor.getValue();

        assertThat(captorInteger).isEqualTo(2);
    }
}