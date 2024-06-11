package com.academy.edge.studentmanager.controllers;

import com.academy.edge.studentmanager.dtos.*;
import com.academy.edge.studentmanager.services.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

    final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) { this.activityService = activityService; }

    @GetMapping("/{email}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #email")
    public ResponseEntity<List<ActivityResponseDTO>> getAllActivities(@PathVariable String email){
        return new ResponseEntity<>(activityService.getAllActivities(email), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR') or authentication.name == #activityCreateDTO.getStudentEmail()")
    public ResponseEntity<ActivityResponseDTO> saveActivity(@Valid @RequestBody ActivityCreateDTO activityCreateDTO){
        ActivityResponseDTO activityResponseDTO = activityService.saveActivity(activityCreateDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(activityResponseDTO.getActivityId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);

        return new ResponseEntity<>(activityResponseDTO, responseHeaders, HttpStatus.CREATED);
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
