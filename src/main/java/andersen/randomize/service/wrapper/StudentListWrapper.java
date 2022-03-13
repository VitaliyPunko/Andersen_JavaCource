package andersen.randomize.service.wrapper;

import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;

import java.util.ArrayList;

public class StudentListWrapper {

    public StudentListWrapper() {
    }

    private ArrayList<Student> students;

    private Lesson lesson;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
