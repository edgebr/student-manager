package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.ActivityCreateDTO;
import com.academy.edge.studentmanager.dtos.ActivityResponseDTO;
import com.academy.edge.studentmanager.models.Activity;
import com.academy.edge.studentmanager.models.Student;
import com.academy.edge.studentmanager.services.ActivityService;
import com.academy.edge.studentmanager.repositories.ActivityRepository;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    final ActivityRepository activityRepository;
    final StudentRepository studentRepository;
    final ModelMapper modelMapper;

    @Autowired
    public ActivityServiceImpl(ModelMapper modelMapper, ActivityRepository activityRepository, StudentRepository studentRepository)
    {
        this.activityRepository = activityRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public ActivityResponseDTO saveActivity(ActivityCreateDTO activityCreateDTO) {
        Activity activity = modelMapper.map(activityCreateDTO, Activity.class);
        try{
            Student student = studentRepository
                    .findByEmail(activityCreateDTO.getStudentEmail())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Student not found"));
            activity.setStudent(student);

            activityRepository.save(activity);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

        return modelMapper.map(activity, ActivityResponseDTO.class);
    }

}
