package com.academy.edge.studentmanager.models;

import com.academy.edge.studentmanager.enums.SubjectStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(GradesId.class)
@Table(name = "grades")
public class Grades {
    @Id
    @Column(nullable = false)
    private String subjectCode;

    @Id
    @Column(nullable = false)
    private String studentId;

    @Id
    @Column(nullable = false)
    private Integer period;

    @Column
    private Integer finalGrade;

    @Enumerated(EnumType.STRING)
    @Column
    private SubjectStatus subjectStatus;
}