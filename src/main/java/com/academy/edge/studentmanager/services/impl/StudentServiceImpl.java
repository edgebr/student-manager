package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.StudentCreateDTO;
import com.academy.edge.studentmanager.dtos.StudentResponseDTO;
import com.academy.edge.studentmanager.models.Student;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;

    final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<StudentResponseDTO> getStudents() {
        List<StudentResponseDTO> students = new ArrayList<>();
        this.studentRepository.findAll().forEach(student -> students.add(modelMapper.map(student, StudentResponseDTO.class)));
        return students;
    }

    @Override
    public StudentResponseDTO getStudentById(String uuid) {
        Student student = studentRepository
                .findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Student not found"));
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO insertStudent(StudentCreateDTO studentCreateDTO) {
        Student student = modelMapper.map(studentCreateDTO, Student.class);
        student = this.studentRepository.save(student);
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public void deleteStudent(String uuid) {
        this.studentRepository.findById(uuid).ifPresent(this.studentRepository::delete);
    }
}
