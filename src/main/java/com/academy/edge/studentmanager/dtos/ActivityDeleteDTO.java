package com.academy.edge.studentmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActivityDeleteDTO {

    @NotBlank
    private String activityId;

    @NotBlank
    private String studentEmail;

}
