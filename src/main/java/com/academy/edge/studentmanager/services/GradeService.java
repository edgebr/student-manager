package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;

public interface GradeService {


    GradeResponseDTO updateGrade(GradeUpdateDTO gradeUpdateDTO);

}
