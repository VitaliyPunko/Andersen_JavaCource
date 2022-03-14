create table students
(
    id  int auto_increment
        primary key,
    name  varchar(30) not null,
    score  double  null,
    is_capitan boolean,
    team_id int not null
)

GO
alter table students
   add constraint team_student__id_fk
    foreign key (team_id) references teams (id)
GO