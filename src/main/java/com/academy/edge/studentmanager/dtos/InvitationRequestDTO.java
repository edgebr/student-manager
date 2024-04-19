package com.academy.edge.studentmanager.dtos;


import com.academy.edge.studentmanager.validators.EmailCollection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class InvitationRequestDTO {

    @EmailCollection
    @Schema(description = "List of Emails for Invitation", example = "[elmo@edge.ufal.br, bert@edge.ufal.br]")
    private List<String> emails;
}
