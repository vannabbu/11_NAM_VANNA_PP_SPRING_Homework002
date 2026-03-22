package com.vannanamkh.springcrud.repository;


import com.vannanamkh.springcrud.model.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "mapper" , value = {
            @Result(property = "instructorName" , column = "instructor_name"),
            @Result(property = "id" , column = "instructor_id")
    })
    @Select("SELECT * FROM instructors LIMIT #{size} OFFSET ${(page - 1) * size}")
    List<Instructor> getALlInstructors(int page , int size);

    @ResultMap("mapper")
    @Select("SELECT * FROM instructors where instructor_id = #{id}")
    Instructor getInstructorById(Long id);

    @ResultMap("mapper")
    @Select("insert into Instructors (instructor_name , email) values (@{instructorName} , @{email})")
    Instructor postInstructor(Instructor instructor);

    @ResultMap("mapper")
    @Select("update instructor set instructor_name = #{req.instructorName} , email = #{req.email}")
    List<Instructor> updateInstructor(Long id , @Param("req") Instructor instructor);

    @ResultMap("mapper")
    @Select("delete from instructor where id = #{id}")
    Instructor deleteInstructor(Long id);
}
