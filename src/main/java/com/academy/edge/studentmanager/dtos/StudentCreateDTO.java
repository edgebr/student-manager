package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import com.academy.edge.studentmanager.validators.ValidBirthdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor()
public class StudentCreateDTO {
    @NotBlank(message = "Nome é obrigatório")
    @Schema(description = "Student Name", example = "Elmo")
    private String name;

    @NotNull(message = "Insira uma data de nascimento")
    @ValidBirthdate(message = "Informe uma data de nascimento válida")
    @Schema(description = "Student Birth Date", example = "1985-02-03")
    private String birthDate;

    @NotBlank(message = "Insira um email")
    @Email(message = "Email inválido")
    @Schema(description = "Student Email", example = "elmo@edge.ufal.br")
    private String email;

    @NotBlank(message = "Insira uma senha")
    @Size(min = 8, max = 20, message = "A senha deve estar entre 8 e 20 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "A senha deve conter ao menos uma letra minúscula, uma maiúscula e um digito")
    @Schema(description = "Password", example = "Password123")
    private String password;

    @NotNull(message = "Curso é obrigatório")
    @Schema(description = "Student Course", example = "COMPUTER_SCIENCE")
    private Course course;

    @NotBlank(message = "Insira um número de matrícula")
    @Pattern(regexp = "\\d+", message = "Informe uma matricula válida")
    @Size(min = 8, max = 8, message = "Informe uma matrícula válida")
    @Schema(description = "Student Registration Number", example = "20201234")
    private String registration;

    @NotBlank(message = "Insira um número de telefone")
    @Pattern(regexp = "\\d{2}9\\d{8}", message = "Informe um número de telefone válido")
    @Schema(description = "Student Primary Phone Number", example = "82940028922")
    private String phone;

    @Pattern(regexp = "(\\d{2}9\\d{8})|($)", message = "Informe um número de telefone secundário válido")
    @Schema(description = "Student Secondary Phone Number", example = "82940028922")
    private String secondaryPhone;

    @NotNull(message = "Insira o periodo")
    @Max(10)
    @Min(1)
    @Schema(description = "Student Current Academy Period", example = "4")
    private int period;

    @NotBlank(message = "Insira o periodo de entrada no curso")
    @Pattern(regexp = "\\d{4}\\.[1-2]", message = "Informe um periodo válido")
    @Schema(description = "Student Entry Academy Year (Period)", example = "2021.2")
    private String entryPeriod;

    @NotBlank(message = "Código de ativação é obrigatório")
    @Schema(description = "Student Activation Code of Invitation")
    private String activationCode;
}
