package andersen.randomize.service.wrapper;

import andersen.randomize.entity.Student;

import java.util.ArrayList;

public class StudentListWrapper {

    public StudentListWrapper() {
    }

    private ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
