package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import com.academy.edge.studentmanager.dtos.StudentResponseDTO;
import com.academy.edge.studentmanager.models.Student;
import com.academy.edge.studentmanager.repositories.GradeRepository;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.services.GradeService;
import com.academy.edge.studentmanager.services.InvitationService;
import com.academy.edge.studentmanager.services.S3Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.academy.edge.studentmanager.models.Grade;
import com.academy.edge.studentmanager.models.GradeId;


import static org.springframework.http.HttpStatus.*;

@Service
public class GradeServiceImpl implements GradeService {

    final GradeRepository gradeRepository;
    final ModelMapper modelMapper;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository, ModelMapper modelMapper) {
        this.gradeRepository = gradeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GradeResponseDTO updateGrade(GradeUpdateDTO gradeUpdateDTO) {


        Grade grade = gradeRepository
                .findByEmail(email) // Mudar pra outro find?
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Grade not found with id: " + /*id*/));

        modelMapper.map(gradeUpdateDTO, grade);
        gradeRepository.save(grade);

        return modelMapper.map(grade, GradeResponseDTO.class);
    }


}
