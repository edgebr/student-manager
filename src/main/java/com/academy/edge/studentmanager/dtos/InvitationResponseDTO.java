package com.academy.edge.studentmanager.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InvitationResponseDTO {
    @Schema(description = "List of successful invitation emails", example = "[ernie@edge.ufal.br, snuffy@edge.ufal.br]")
    private List<String> successfulEmails= new ArrayList<>();

    @Schema(description = "List of failed invitation emails", example = "[chico.bento@ic.ufal.br, cebolinha@gmail.com]")
    private List<String> failedEmails = new ArrayList<>();
}
