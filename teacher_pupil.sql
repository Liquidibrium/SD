CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY NOT NULL,
    first_name varchar(30),
    last_name varchar(30),
    gender varchar(30),
    subject varchar(30)
);
CREATE TABLE Students (
    student_id INT PRIMARY KEY NOT NULL,
    first_name varchar(30),
    last_name varchar(30),
    gender varchar(30),
    course_id INT ,
);
   
CREATE TABLE courses
   ( 
      course_id INT  NOT NULL,
      teacher_id int , 
      course_name VARCHAR(30) ,
      CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id)
   ) ;
   
   
   SELECT first_name|| ' ' || last_name
from Teachers
where teacher_id in 
  (select teacher_id
   from courses
   where course_id in 
     (select course_id
      from students
      where first_name = 'გიორგი')
 );