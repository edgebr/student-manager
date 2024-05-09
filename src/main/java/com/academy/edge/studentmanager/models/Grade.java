package com.academy.edge.studentmanager.models;

import com.academy.edge.studentmanager.enums.SubjectStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(GradeId.class)
@Table(name = "grades")
public class Grade {
    @Id
    @ManyToOne
    @JoinColumn(name = "subjectCode", referencedColumnName = "code")
    private Subject subject;

    @Id
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @Id
    @Column(nullable = false)
    private Integer period;

    @Column
    private Integer finalGrade;

    @Enumerated(EnumType.STRING)
    @Column
    private SubjectStatus subjectStatus;
}