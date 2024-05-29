package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.ActivityType;
import jakarta.validation.constraints.*;
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
    private int workShift;

    @NotNull
    @Pattern(regexp = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$",
            message = "Insira uma data válida no modelo yyyy-mm-dd")
    private String startDate;

    @Pattern(regexp = "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$",
            message = "Insira uma data válida no modelo yyyy-mm-dd")
    private String conclusionDate;

    @NotNull
    private boolean onGoing;

    @NotNull
    private boolean isPaid;
}
