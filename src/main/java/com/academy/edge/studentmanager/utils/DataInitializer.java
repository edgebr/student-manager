package com.academy.edge.studentmanager.utils;


import com.academy.edge.studentmanager.enums.Role;
import com.academy.edge.studentmanager.models.Invitation;
import com.academy.edge.studentmanager.models.User;
import com.academy.edge.studentmanager.repositories.InstructorRepository;
import com.academy.edge.studentmanager.repositories.StudentRepository;
import com.academy.edge.studentmanager.repositories.InvitationRepository;
import com.academy.edge.studentmanager.repositories.UserRepository;
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
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) {
        if (userRepository.findByEmail("admin@admin.com") == null) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("Admin123"));
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }

//        if(studentRepository.findByEmail("aluno@aluno.com").isEmpty()) {
//            Student student = new Student();
//            student.setName("Aluno");
//            student.setEmail("aluno@aluno.com");
//            student.setPassword(passwordEncoder.encode("Aluno123"));
//            student.setCourse(Course.COMPUTER_SCIENCE);
//            student.setRegistration("22111533");
//            student.setPhone("82940028922");
//            student.setPeriod(3);
//            student.setEntryPeriod("2022.1");
//            student.setStudentGroup(1);
//            student.setEntryDate(Date.valueOf(LocalDate.now()));
//            student.setBirthDate(Date.valueOf(LocalDate.now()));
//            studentRepository.save(student);
//        }

        // Initialize 50 invitations for manual testing purposes :D
        for (int i = 0; i < 50; i++) {
            Invitation invitation = new Invitation();

            invitation.setEmail(String.format("test%d@edge.ufal.br", i));
            invitation.setStudentGroup(1);
            invitation.setEntryDate(Date.valueOf("2001-01-01"));
            invitation.setCode(String.valueOf(i));

            invitationRepository.save(invitation);
        }
    }
}
