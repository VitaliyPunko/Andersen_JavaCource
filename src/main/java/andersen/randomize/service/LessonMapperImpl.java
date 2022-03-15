package andersen.randomize.service;

import andersen.randomize.entity.Lesson;
import andersen.randomize.entity.dto.LessonDto;
import org.springframework.stereotype.Service;

@Service
public class LessonMapperImpl {

    public Lesson toEntity(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setDate(lessonDto.getDate());
        lesson.setStudents(lessonDto.getStudents());
        return lesson;
    }
}
