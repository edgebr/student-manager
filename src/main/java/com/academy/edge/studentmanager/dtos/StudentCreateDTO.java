package com.academy.edge.studentmanager.dtos;

import com.academy.edge.studentmanager.enums.Course;
import com.academy.edge.studentmanager.validators.FutureDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@AllArgsConstructor()
public class StudentCreateDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    private String email;

    @Size(min = 8, max = 20, message = "A senha deve estar entre 8 e 20 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "A senha deve conter ao menos uma letra minúscula, uma maiúscula e um digito")
    private String password;

    @NotNull(message = "Curso é obrigatório")
    private Course course;

    @Pattern(regexp = "\\d+", message = "Informe uma matricula válida")
    @Size(min = 8, max = 8, message = "Informe uma matrícula válida")
    private String registration;

    @NotNull
    @Pattern(regexp = "\\d{2}9\\d{8}", message = "Informe um número de telefone válido")
    private String phone;

    @Pattern(regexp = "\\d{2}9\\d{8}", message = "Informe um número de telefone válido")
    private String secondaryPhone;

    @FutureDate(message = "Informe uma data de nascimento válida")
    private String birthDate;

    @Max(10)
    @Min(1)
    private int period;

    @Pattern(regexp = "\\d{4}\\.[1-2]", message = "Informe um periodo válido")
    private String entryPeriod;

    @NotBlank(message = "Código de ativação é obrigatório")
    private String activationCode;
}
