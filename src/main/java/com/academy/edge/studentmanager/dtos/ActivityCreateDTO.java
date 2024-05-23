package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.ActivityType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActivityCreateDTO {

    @NotNull
    private ActivityType activityType;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(1)
    private int hours;

    @NotNull
    private Date startDate;

    private Date conclusionDate;

    @NotNull
    private boolean onGoing;

    @NotNull
    private boolean paid;
}
