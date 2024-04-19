package com.academy.edge.studentmanager.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class JwtAuthResponseDTO {
    @Schema(description = "JWT Token")
    String token;
}
