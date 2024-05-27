package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.ActivityType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityUpdateDTO {

    @NotNull
    private ActivityType activityType;

    @NotNull
    private String activityId;

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "Email inválido")
    private String studentEmail;

    @NotBlank
    private String description;

    @NotNull
    @Min(1)
    private int hours;

    @NotNull
    private String startDate;

    private String conclusionDate;

    @NotNull
    private boolean onGoing;

    @NotNull
    private boolean paid;
}
