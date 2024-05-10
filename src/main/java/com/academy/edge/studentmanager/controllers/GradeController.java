package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import com.academy.edge.studentmanager.models.Grade;
import com.academy.edge.studentmanager.models.GradeId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {



    @PutMapping({"/{email}"}) // Mudar pra grade
    public ResponseEntity<GradeResponseDTO> updateGrade(@PathVariable String email,
                                                                   @RequestBody @Valid GradeUpdateDTO gradeUpdateDTO) {
        GradeResponseDTO gradeResponseDTO = GradeService.updateGrade();

        return new ResponseEntity<>(gradeResponseDTO, HttpStatus.OK);
    }
}