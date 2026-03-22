package com.vannanamkh.springcrud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesRequest {
    private String courseName ;
    private String description;
    private int instructorId ;
}
