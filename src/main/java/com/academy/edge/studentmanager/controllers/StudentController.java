package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.StudentCreateDTO;
import com.academy.edge.studentmanager.dtos.StudentResponseDTO;
import com.academy.edge.studentmanager.dtos.StudentUpdateDTO;
import com.academy.edge.studentmanager.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.principal.id == #id")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable String id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<StudentResponseDTO> saveStudent(@ModelAttribute @Valid StudentCreateDTO studentCreateDTO,
                                                          @RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(studentService.insertStudent(studentCreateDTO, file), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping({"/{id}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.principal.id == #id")
    public ResponseEntity<StudentResponseDTO> updateStudentById(@PathVariable String id,
                                                     @RequestBody @Valid StudentUpdateDTO studentUpdateDTO) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentUpdateDTO);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PutMapping({"/{id}/photo"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.principal.id == #id")
    public ResponseEntity<StudentResponseDTO> updateStudentPhotoById(@PathVariable String id,
                                                                        @RequestParam("file") MultipartFile file) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudentPhoto(id, file);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PutMapping({"/{id}/record"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.principal.id == #id")
    public ResponseEntity<StudentResponseDTO> updateStudentAcademicRecordById(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudentAcademicRecord(id, file);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }
}
