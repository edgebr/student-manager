package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.ActivityType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ActivityResponseDTO {

    private ActivityType activityType;
    private String name;
    private String description;
    private int hours;
    private Date startDate;
    private Date conclusionDate;
    private boolean onGoing;
    private boolean paid;

}
