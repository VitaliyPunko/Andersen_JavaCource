package andersen.randomize.dao;

import andersen.randomize.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
