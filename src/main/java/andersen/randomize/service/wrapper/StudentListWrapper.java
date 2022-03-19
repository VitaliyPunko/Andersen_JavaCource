package andersen.randomize.service.wrapper;

import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class StudentListWrapper {

    public StudentListWrapper() {
    }

    public StudentListWrapper(ArrayList<Student> students, Lesson lesson, double askGrade, double answerGrade) {
        this.students = students;
        this.lesson = lesson;
        this.askGrade = askGrade;
        this.answerGrade = answerGrade;
    }

    public StudentListWrapper(ArrayList<Student> students, Lesson lesson) {
        this.students = students;
        this.lesson = lesson;
    }

    @NotNull
    private ArrayList<Student> students;

    private Lesson lesson;

    private double askGrade;

    private double answerGrade;

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

    public double getAskGrade() {
        return askGrade;
    }

    public double getAnswerGrade() {
        return answerGrade;
    }

    public void setAskGrade(double askGrade) {
        this.askGrade = askGrade;
    }

    public void setAnswerGrade(double answerGrade) {
        this.answerGrade = answerGrade;
    }
}
