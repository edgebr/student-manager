package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.repositories.GradeRepository;
import com.academy.edge.studentmanager.repositories.SubjectRepository;
import com.academy.edge.studentmanager.services.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.academy.edge.studentmanager.models.Grade;

import static org.springframework.http.HttpStatus.*;

@Service
public class GradeServiceImpl implements GradeService {

    final GradeRepository gradeRepository;
    final ModelMapper modelMapper;

    StudentRepository studentRepository;
    SubjectRepository subjectRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository, ModelMapper modelMapper, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public GradeResponseDTO updateGrade(GradeUpdateDTO gradeUpdateDTO) {

        Grade grade = gradeRepository
                        .findGradeByStudent_IdAndSubject_CodeAndPeriod(
                                gradeUpdateDTO.getStudentId(),
                                gradeUpdateDTO.getSubjectId(),
                                gradeUpdateDTO.getPeriod())
                        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Grade not found "));

        modelMapper.map(gradeUpdateDTO, grade);
        gradeRepository.save(grade);
        return modelMapper.map(grade, GradeResponseDTO.class);
    }


}
