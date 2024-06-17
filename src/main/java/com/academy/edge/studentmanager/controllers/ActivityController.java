package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.ActivityCreateDTO;
import com.academy.edge.studentmanager.dtos.ActivityResponseDTO;
import com.academy.edge.studentmanager.dtos.ActivityUpdateDTO;
import com.academy.edge.studentmanager.dtos.ActivityDeleteDTO;
import com.academy.edge.studentmanager.services.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

    final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) { this.activityService = activityService; }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.principal.id == #userId")
    public ResponseEntity<List<ActivityResponseDTO>> getAllActivities(@RequestParam String userId){
        return new ResponseEntity<>(activityService.getAllActivities(userId), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #activityCreateDTO.getStudentEmail()")
    public ResponseEntity<ActivityResponseDTO> saveActivity(@Valid @RequestBody ActivityCreateDTO activityCreateDTO){
        return new ResponseEntity<>(activityService.saveActivity(activityCreateDTO), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR') or authentication.name == #activityUpdateDTO.getStudentEmail()")
    public ResponseEntity<ActivityResponseDTO> updateActivity(@Valid @RequestBody ActivityUpdateDTO activityUpdateDTO){
        return new ResponseEntity<>(activityService.updateActivity(activityUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #activityDeleteDTO.getStudentEmail()")
    public ResponseEntity<Void> deleteActivity(@Valid @RequestBody ActivityDeleteDTO activityDeleteDTO){
        activityService.deleteActivity(activityDeleteDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
