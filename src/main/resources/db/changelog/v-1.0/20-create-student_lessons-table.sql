create table student_lesson
(
    student_id int not null,
    lesson_id    int not null,
    primary key (student_id, lesson_id),
    constraint lesson_student__id_fk
        foreign key (lesson_id) references lessons (id),
    constraint lesson_student_id_fk
        foreign key (student_id) references students (id)
);