package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeDeleteDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;

public interface GradeService {
    GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO);

    void deleteGrade(GradeDeleteDTO gradeDeleteDTO);
}
