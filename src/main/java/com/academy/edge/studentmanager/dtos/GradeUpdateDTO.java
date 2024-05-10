package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import com.academy.edge.studentmanager.validators.ValidBirthdate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class GradeUpdateDTO {
    @NotBlank
    private String status;
    @NotNull
    private double finalGrade;
    @NotBlank
    private String subjectId;
    @NotNull
    private int period;
    @NotBlank
    private String studentId;
}
