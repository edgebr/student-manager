package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.InstructorResponseDTO;
import com.academy.edge.studentmanager.services.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    @Operation(summary = "Retrieve all Instructors infos", security = {@SecurityRequirement(name = "JWT")})
    public ResponseEntity<List<InstructorResponseDTO>> getAllInstructors(){
        return new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
    }

    @GetMapping({"/{email}"})
    @Operation(summary = "Retrieve instructors by email", security = {@SecurityRequirement(name = "JWT")})
    public ResponseEntity<InstructorResponseDTO> getInstructor(@Parameter(description = "Email of searched Instructor") @PathVariable String email){
        return new ResponseEntity<>(instructorService.getInstructorByEmail(email), HttpStatus.OK);
    }
}
