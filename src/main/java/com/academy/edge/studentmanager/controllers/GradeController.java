package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.services.GradeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {
    final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR', 'STUDENT')")
    public ResponseEntity<GradeResponseDTO> saveGrade(@Valid @RequestBody GradeCreateDTO gradeCreateDTO){
        return new ResponseEntity<>(gradeService.saveGrade(gradeCreateDTO), HttpStatus.OK);
    }
}
