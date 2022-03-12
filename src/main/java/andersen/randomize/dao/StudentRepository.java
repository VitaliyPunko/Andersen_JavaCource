package andersen.randomize.dao;

import andersen.randomize.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query(
            value = "SELECT s.id, s.name, s.score, s.is_capitan, s.team_id from students as s" +
                    "    JOIN student_lesson sl on s.id = sl.student_id\n" +
                    "    JOIN lessons l on l.id = sl.lesson_id\n" +
                    "where l.date = :date",
            nativeQuery = true
    )
    List<Student> findAllByDate(LocalDate date);

}
