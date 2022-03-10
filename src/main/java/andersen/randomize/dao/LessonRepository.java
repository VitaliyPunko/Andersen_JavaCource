package andersen.randomize.dao;

import andersen.randomize.entity.Lessons;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lessons, Integer> {
}
