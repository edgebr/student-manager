package com.academy.edge.studentmanager.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequestDTO {
    @Email
    @Schema(description = "Email", example = "big.bird@edge.ufal.br")
    private String email;

    @Size(min = 8, max = 20)
    @Schema(description = "Password", example = "Password123", pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")
    private String password;
}
