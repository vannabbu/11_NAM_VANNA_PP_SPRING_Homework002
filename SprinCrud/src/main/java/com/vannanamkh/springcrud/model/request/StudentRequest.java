package com.vannanamkh.springcrud.model.request;

import com.vannanamkh.springcrud.model.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName ;
    private String email ;
    private String phoneNumber ;
    private List<Long> courseId;
}
