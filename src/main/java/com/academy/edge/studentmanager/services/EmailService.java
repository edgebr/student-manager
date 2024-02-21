package com.academy.edge.studentmanager.services;

public interface EmailService {
    public void sendEmail(String to, String subject, String text);
}
