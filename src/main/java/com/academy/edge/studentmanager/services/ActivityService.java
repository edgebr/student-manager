package com.academy.edge.studentmanager.services;

import com.academy.edge.studentmanager.dtos.ActivityDeleteDTO;
import com.academy.edge.studentmanager.dtos.ActivityResponseDTO;
import com.academy.edge.studentmanager.dtos.ActivityCreateDTO;
import com.academy.edge.studentmanager.dtos.ActivityUpdateDTO;

public interface ActivityService {

    ActivityResponseDTO saveActivity(ActivityCreateDTO activityCreateDTO);

    ActivityResponseDTO updateActivity(ActivityUpdateDTO activityUpdateDTO);

    void deleteActivity(ActivityDeleteDTO activityDeleteDTO);
}
