package com.academy.edge.studentmanager.utils;


import com.academy.edge.studentmanager.enums.InstructorSpecialization;
import com.academy.edge.studentmanager.models.Instructor;
import com.academy.edge.studentmanager.models.Invitation;
import com.academy.edge.studentmanager.repositories.InstructorRepository;
import com.academy.edge.studentmanager.repositories.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) {
        if (instructorRepository.findByEmail("admin@admin.com").isEmpty()) {
            Instructor instructor = new Instructor();
            instructor.setName("Admin");
            instructor.setEmail("admin@admin.com");
            instructor.setPassword(passwordEncoder.encode("Admin123"));
            instructor.setSpecialization(InstructorSpecialization.TECHNICAL);
            instructorRepository.save(instructor);
        }

        // Initialize 50 invitations for manual testing purposes :D
        for (int i = 0; i < 50; i++) {
            Invitation invitation = new Invitation();

            invitation.setEmail(String.format("test%d@test.com", i));
            invitation.setStudentGroup(1);
            invitation.setEntryDate(Date.valueOf("2001-01-01"));
            invitation.setCode(String.valueOf(i));

            invitationRepository.save(invitation);
        }
    }
}
