package com.vannanamkh.springcrud.repository;

import com.vannanamkh.springcrud.model.Students;
import com.vannanamkh.springcrud.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "mapper" , value = {
            @Result(property = "studentName" , column = "student_name"),
            @Result(property = "id" , column = "student_id"),
            @Result(property = "phoneNumber" , column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                   many = @Many(select = "com.vannanamkh.springcrud.repository.StudentCourseRepository.findCoursesByStudentId"))
    })
    @Select("SELECT * FROM students LIMIT #{size} OFFSET ${(page - 1) * size}")
    List<Students> getAllStudent(int page , int size) ;

    @ResultMap("mapper")
    @Select("SELECT * FROM students where student_id = #{id}")
    Students getStudentBuyId(Long id);

    @ResultMap("mapper")
    @Select("insert into students (student_name , email , phone_number ) values (#{studentName} , #{email} , #{phoneNumber}) RETURNING *")
    Students postStudent(StudentRequest studentRequest);

    @ResultMap("mapper")
    @Select("update students set student_name = #{req.studentName} , email = #{req.email} , phone_number = #{req.phoneNumber} where student_id = #{id} RETURNING *")
    Students updateStudent(Long id , @Param("req") StudentRequest studentRequest);


    @ResultMap("mapper")
    @Select("delete from students where student_id = #{id} RETURNING *")
    Students deleteStudent(Long id);
}
