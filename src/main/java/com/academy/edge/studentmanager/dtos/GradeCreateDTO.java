package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.SubjectStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeCreateDTO {
    @NotBlank
    private String subjectCode;

    @NotBlank
    private String studentId;

    @NotNull
    @Min(1)
    @Max(12)
    private int period;

    @NotNull
    @Min(value = 0, message = "A nota deve estar entre 0 e 10")
    @Max(value = 10, message = "A nota deve estar entre 0 e 10")
    private Double finalGrade;

    @NotNull
    private SubjectStatus subjectStatus;
}
