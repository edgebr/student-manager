package com.academy.edge.studentmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradesId implements Serializable{
    private String subjectCode;
    private String studentId;
    private Integer period;
}
