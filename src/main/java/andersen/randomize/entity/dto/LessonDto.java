package andersen.randomize.entity.dto;

import andersen.randomize.entity.Student;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class LessonDto {

    public LessonDto() {
    }

    public LessonDto(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "date is a required field")
    private LocalDate date;

    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
