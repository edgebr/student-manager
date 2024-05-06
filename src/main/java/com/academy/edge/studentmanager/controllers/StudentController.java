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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping({"/{email}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #email")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable String email){
        return new ResponseEntity<>(studentService.getStudentByEmail(email), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<StudentResponseDTO> saveStudent(@ModelAttribute @Valid StudentCreateDTO studentCreateDTO,
                                                          @RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(studentService.insertStudent(studentCreateDTO, file), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{email}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public ResponseEntity<Void> deleteStudent(@PathVariable String email){
        studentService.deleteStudent(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping({"/{email}"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public ResponseEntity<StudentResponseDTO> updateStudentByEmail(@PathVariable String email,
                                                     @RequestBody @Valid StudentUpdateDTO studentUpdateDTO) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(email, studentUpdateDTO);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @PutMapping({"/{email}/photo"})
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public ResponseEntity<StudentResponseDTO> updateStudentPhotoByEmail(@PathVariable String email,
                                                                        @RequestParam("file") MultipartFile file) {
        StudentResponseDTO studentResponseDTO = studentService.updateStudentPhoto(email, file);

        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }


    @GetMapping("/me")
    public ResponseEntity<StudentResponseDTO> getCurrentStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            StudentResponseDTO studentResponseDTO = studentService.getStudentByEmail(email);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No student logged in");
        }
    }

    @PutMapping("/me")
    public ResponseEntity<StudentResponseDTO> updateCurrentStudent(@RequestBody @Valid StudentUpdateDTO studentUpdateDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            StudentResponseDTO studentResponseDTO = studentService.updateStudent(email, studentUpdateDTO);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No student logged in");
        }
    }

    @PutMapping("/me/photo")
    public ResponseEntity<StudentResponseDTO> updateCurrentStudentPhoto(
            @RequestParam("file") MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            StudentResponseDTO studentResponseDTO = studentService.updateStudentPhoto(email, file);
            return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No student logged in");
        }
    }
}
