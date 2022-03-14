package andersen.randomize.service.wrapper;

import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentListWrapper {

    public StudentListWrapper() {
    }

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
