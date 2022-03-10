package andersen.randomize.dao;

import andersen.randomize.entity.Date;
import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<Date, Integer> {
}
