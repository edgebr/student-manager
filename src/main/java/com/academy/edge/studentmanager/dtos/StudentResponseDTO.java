package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    @Schema(description = "Student UUID", example = "f4e5e0a6-8a4a-4c0e-8e3e-1e2b7f8c9d0e")
    private String id;

    @Schema(description = "Student Name", example = "Elmo")
    private String name;

    @Schema(description = "Student Photo URL", example = "https://example.com/images/image.jpg")
    private String photoUrl;

    @Schema(description = "Student Birth Date", example = "1985-02-03")
    private Date birthDate;

    @Schema(description = "Student Course", example = "COMPUTER_SCIENCE")
    private Course course;

    @Schema(description = "Student Registration Number", example = "20201234")
    private String registration;

    @Schema(description = "Student Primary Phone Number", example = "82940028922")
    private String phone;

    @Schema(description = "Student Secondary Phone Number", example = "82940028922")
    private String secondaryPhone;

    @Schema(description = "Student Current Academy Period", example = "4")
    private String period;

    @Schema(description = "Student Entry Academy Year (Period)", example = "2021.2")
    private String entryPeriod;

    @Schema(description = "User Dtype", example = "Student")
    private String dtype;

    @Schema(description = "Student Email", example = "elmo@edge.ufal.br")
    private String email;

    @Schema(description = "User Entry Date", example = "2024-01-01")
    private Date entryDate;

}
