package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

public class GradeResponseDTO {
    private String status;
    private double finalGrade;
    private String subjectId;
    private int period;
    private String studentId;
}
