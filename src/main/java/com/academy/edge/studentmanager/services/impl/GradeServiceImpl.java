package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeUpdateDTO;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.repositories.GradeRepository;
import com.academy.edge.studentmanager.repositories.SubjectRepository;
import com.academy.edge.studentmanager.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.academy.edge.studentmanager.models.Grade;
import com.academy.edge.studentmanager.models.Student;
import com.academy.edge.studentmanager.models.Subject;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMappe;
import static org.springframework.http.HttpStatus.*;


@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {
    final GradeRepository gradeRepository;
    final StudentRepository studentRepository;
    final SubjectRepository subjectRepository;
    final ModelMapper modelMapper;

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
  
    @Override
    @Transactional
    public GradeResponseDTO saveGrade(GradeCreateDTO gradeCreateDTO) {
        Grade grade = modelMapper.map(gradeCreateDTO, Grade.class);
        try{
            Student student = studentRepository
                    .findByEmail(gradeCreateDTO.getStudentEmail())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Student not found"));
            grade.setStudent(student);

            Subject subject = subjectRepository.
                    findSubjectByCode(gradeCreateDTO.getSubjectCode())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Subject not found"));
            grade.setSubject(subject);

            gradeRepository.save(grade);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

        return modelMapper.map(grade, GradeResponseDTO.class);
    }

}
