package com.academy.edge.studentmanager.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityDeleteDTO {

    @NotBlank
    private String activityId;

    @NotBlank
    @Email(message = "Email inválido")
    private String studentEmail;

}