package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.dtos.ActivityCreateDTO;
import com.academy.edge.studentmanager.dtos.ActivityResponseDTO;
import com.academy.edge.studentmanager.models.Activity;
import com.academy.edge.studentmanager.services.ActivityService;
import com.academy.edge.studentmanager.repositories.ActivityRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    final ActivityRepository activityRepository;
    final ModelMapper modelMapper;

    @Autowired
    public ActivityServiceImpl(ModelMapper modelMapper, ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ActivityResponseDTO saveActivity(ActivityCreateDTO activityCreateDTO) {
        Activity activity = modelMapper.map(activityCreateDTO, Activity.class);

        try{

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

        return modelMapper.map(activity, ActivityResponseDTO.class);
    }

}
