package andersen.randomize.service.wrapper;

import andersen.randomize.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentListWrapper {

    public StudentListWrapper() {
    }

    private ArrayList<Student> students;

    private LocalDate date;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
