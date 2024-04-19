package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.InstructorSpecialization;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstructorResponseDTO {
    @Schema(description = "Instructor UUID", example = "f4e5e0a6-8a4a-4c0e-8e3e-1e2b7f8c9d0e")
    private String id;
    @Schema(description = "Instructor Name", example = "Cookie Monster")
    private String name;
    @Schema(description = "Instructor Photo URL", example = "https://example.com/images/image.jpg")
    private String photoUrl;
    @Schema(description = "Instructor Specialization", example = "TECHNICAL")
    private InstructorSpecialization specialization;
}
