package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.StudentCreateDTO;
import com.academy.edge.studentmanager.dtos.StudentResponseDTO;
import com.academy.edge.studentmanager.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @Operation(summary = "Retrieve all Students infos", security = {@SecurityRequirement(name = "JWT")})
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping({"/{email}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #email")
    @Operation(summary = "Retrieve Student info by email", security = {@SecurityRequirement(name = "JWT")})
    public ResponseEntity<StudentResponseDTO> getStudent(@Parameter(description = "Email of searched Student") @PathVariable String email){
        return new ResponseEntity<>(studentService.getStudentByEmail(email), HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Create Student")
    public ResponseEntity<StudentResponseDTO> saveStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO){
        return new ResponseEntity<>(studentService.insertStudent(studentCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{email}"})
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "Delete Student by email (SoftDelete)", security = {@SecurityRequirement(name = "JWT")})
    public ResponseEntity<Void> deleteStudent(@Parameter(description = "Email of deleted Student") @PathVariable String email){
        studentService.deleteStudent(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
