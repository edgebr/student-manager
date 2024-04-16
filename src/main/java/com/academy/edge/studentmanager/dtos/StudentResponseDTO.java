package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private String id;
    private String name;
    private String photoUrl;
    private String birthDate;
    private Course course;
    private String registration;
    private String phone;
    private String secondaryPhone;
    private String period;
    private String entryPeriod;
    private String dtype;
    private String email;
    private String entryDate;

}
