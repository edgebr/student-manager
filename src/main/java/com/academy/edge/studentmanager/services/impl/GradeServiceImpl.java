package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.GradeCreateDTO;
import com.academy.edge.studentmanager.dtos.GradeDeleteDTO;
import com.academy.edge.studentmanager.dtos.GradeResponseDTO;
import com.academy.edge.studentmanager.models.Grade;
import com.academy.edge.studentmanager.models.Student;
import com.academy.edge.studentmanager.models.Subject;
import com.academy.edge.studentmanager.repositories.GradeRepository;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.repositories.SubjectRepository;
import com.academy.edge.studentmanager.services.GradeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService{
    final GradeRepository gradeRepository;
    final StudentRepository studentRepository;
    final SubjectRepository subjectRepository;
    final ModelMapper modelMapper;

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

    @Override
    @Transactional
    public void deleteGrade(GradeDeleteDTO gradeDeleteDTO) {
        Student student = studentRepository
                            .findByEmail(gradeDeleteDTO.getStudentEmail())
                            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Student not found"));

        gradeRepository.deleteGradeByStudentIdAndSubjectCodeAndPeriod(
                            student.getId(),
                            gradeDeleteDTO.getSubjectCode(),
                            gradeDeleteDTO.getPeriod());
    }
}
