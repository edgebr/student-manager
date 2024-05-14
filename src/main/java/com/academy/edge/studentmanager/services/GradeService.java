package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.StudentGradesDTO;

import java.util.List;

public interface GradeService {
    GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO);

    List<StudentGradesDTO> getStudentGrades(String studentId);
}
