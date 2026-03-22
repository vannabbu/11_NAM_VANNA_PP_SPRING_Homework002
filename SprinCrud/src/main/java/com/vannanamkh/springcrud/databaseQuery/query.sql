create database SpringDatabase ;

create table students(
id serial primary key ,
student_name varchar(99),
email varchar(99),
phone_number varchar (99)
)

create table instructors (
instructor_id serial primary key ,
instructor_name varchar(99),
email varchar(90)
)

select * from instructors
create table courses(
        id serial primary key ,
        course_name varchar(99),
        description varchar(99),
        instructor_id int
)

create table students(
                         student_id serial primary key ,
                         student_name varchar(99),
                         email varchar(99),
                         phone_number varchar(99)
)

create table student_course (
    student_id int ,
    course_id int
)