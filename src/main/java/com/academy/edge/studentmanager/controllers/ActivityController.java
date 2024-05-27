package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.ActivityCreateDTO;
import com.academy.edge.studentmanager.dtos.ActivityResponseDTO;
import com.academy.edge.studentmanager.services.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {


    final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) { this.activityService = activityService; }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #activityCreateDTO.getStudentEmail()")
    public ResponseEntity<ActivityResponseDTO> saveActivity(@Valid @RequestBody ActivityCreateDTO activityCreateDTO){
        return new ResponseEntity<>(activityService.saveActivity(activityCreateDTO), HttpStatus.OK);
    }




}
