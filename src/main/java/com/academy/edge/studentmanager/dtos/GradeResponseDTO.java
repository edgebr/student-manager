package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.SubjectStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GradeResponseDTO {
    private String subjectCode;
    private SubjectStatus subjectStatus;
    private String studentId;
    private int period;
    private Double finalGrade;
}
