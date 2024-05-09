package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.SubjectCreateDTO;
import com.academy.edge.studentmanager.dtos.SubjectResponseDTO;
import com.academy.edge.studentmanager.models.Subject;
import com.academy.edge.studentmanager.services.SubjectService;
import com.academy.edge.studentmanager.repositories.SubjectRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    final SubjectRepository subjectRepository;

    final ModelMapper modelMapper;

    @Override
    public List<SubjectResponseDTO> getSubjects() {
        List<SubjectResponseDTO> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subject -> subjects.add(modelMapper.map(subject, SubjectResponseDTO.class)));
        return subjects;
    }

    @Override
    @Transactional
    public SubjectResponseDTO insertSubject(SubjectCreateDTO subjectCreateDTO) {
        Subject subject = modelMapper.map(subjectCreateDTO, Subject.class);

        try{
            subjectRepository.save(subject);
        }
        catch(Exception e){
            throw new RuntimeException();
        }
        return modelMapper.map(subject, SubjectResponseDTO.class);
    }
}
