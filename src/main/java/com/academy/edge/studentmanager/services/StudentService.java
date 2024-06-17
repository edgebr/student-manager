package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.StudentCreateDTO;
import com.academy.edge.studentmanager.dtos.StudentResponseDTO;
import com.academy.edge.studentmanager.dtos.StudentUpdateDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface StudentService {
    List<StudentResponseDTO> getStudents();

    StudentResponseDTO getStudentByEmail(String email);
    StudentResponseDTO getStudentById(String id);

    StudentResponseDTO insertStudent(StudentCreateDTO studentCreateDTO, MultipartFile file);

    StudentResponseDTO updateStudent(String id, StudentUpdateDTO studentUpdateDTO);

    StudentResponseDTO updateStudentPhoto(String id, MultipartFile file);

    void deleteStudent(String id);

    StudentResponseDTO updateStudentAcademicRecord(String id, MultipartFile file);
}
