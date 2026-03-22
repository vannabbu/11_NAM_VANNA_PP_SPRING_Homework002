package com.vannanamkh.springcrud.repository;

import com.vannanamkh.springcrud.model.Courses;
import com.vannanamkh.springcrud.model.Students;
import com.vannanamkh.springcrud.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {

    @Results(id = "mapper" , value = {
            @Result(property = "courseName" , column = "course_name"),
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructor" , column = "instructor_id",
                    one = @One(select = "com.vannanamkh.springcrud.repository.InstructorRepository.getInstructorById")
            )
    })
    @Select("""
    select c.* from courses c
    join student_course sc on sc.course_id = c.id
    where student_id = #{studentId}
    """)
    List<Courses> findCoursesByStudentId(Long studentId);

    @ResultMap("mapper")
    @Select("insert into student_course values (#{studentId} ,#{courseId})")
    void saveStudentCourse(Long studentId ,Long courseId);

    @ResultMap("mapper")
    @Select("update student_course set student_id = #{studentId} ,course_id = #{courseId}")
    void updateStudentCourse(Long courseId,Long studentId);

    @Delete("DELETE FROM student_course WHERE student_id = #{studentId}")
    void deleteByStudentId(@Param("studentId") Long studentId);

}
