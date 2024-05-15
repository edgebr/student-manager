package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import com.academy.edge.studentmanager.dtos.GradeCreateDTO;

public interface GradeService {


    GradeResponseDTO updateGrade(GradeUpdateDTO gradeUpdateDTO);
    GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO);
}
