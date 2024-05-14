package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;

import java.util.List;

public interface GradeService {
    GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO);

    List<GradeResponseDTO> getStudentGrades(String studentId);
}
