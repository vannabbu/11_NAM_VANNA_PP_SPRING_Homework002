package com.vannanamkh.springcrud.repository;

import com.vannanamkh.springcrud.model.Courses;
import com.vannanamkh.springcrud.model.request.CoursesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "mapper" , value = {
            @Result(property = "courseName" , column = "course_name"),
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructor" , column = "instructor_id" ,
            one = @One(select = "com.vannanamkh.springcrud.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
    SELECT * FROM courses
    LIMIT #{size} OFFSET ${(page - 1) * size}
""")
    List<Courses> getCourses( int page,int size);


    @ResultMap("mapper")
    @Select("SELECT * FROM courses where instructor_id = #{id}")
    Courses getCourseById(Long id);


    @ResultMap("mapper")
    @Select("insert into courses (course_name ,description ,instructor_id) values (#{courseName} , #{description} , #{instructorId}) RETURNING  *")
    Courses saveCourse(CoursesRequest coursesRequest);


    @ResultMap("mapper")
    @Select("update courses set  course_name= #{req.} , description = #{req.email} where id = #{id} RETURNING  * ")
    Courses updateCourse(Long id , @Param("req") CoursesRequest coursesRequest);

    @ResultMap("mapper")
    @Select("delete from courses where id = #{id} RETURNING *")
    Courses deleteCourse(Long id);



}
