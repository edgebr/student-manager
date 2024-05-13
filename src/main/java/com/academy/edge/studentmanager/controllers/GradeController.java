package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.services.GradeService;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {

    GradeService gradeService;
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR', 'STUDENT')")
    public ResponseEntity<GradeResponseDTO> updateGrade(@Valid @RequestBody GradeUpdateDTO gradeUpdateDTO) {
        GradeResponseDTO gradeResponseDTO = gradeService.updateGrade(gradeUpdateDTO);

        return new ResponseEntity<>(gradeResponseDTO, HttpStatus.OK);
    }
}