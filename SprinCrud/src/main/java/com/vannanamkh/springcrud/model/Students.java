package com.vannanamkh.springcrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Long id ;
    private String studentName ;
    private String email ;
    private String phoneNumber ;
    private List<Courses> courses;
}
