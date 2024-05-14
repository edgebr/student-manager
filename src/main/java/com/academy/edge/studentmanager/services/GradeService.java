package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeDeleteDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import org.springframework.http.HttpStatus;

public interface GradeService {
    GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO);

    HttpStatus deleteGrade(GradeDeleteDTO gradeDeleteDTO);
}
