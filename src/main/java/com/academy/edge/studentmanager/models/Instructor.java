package com.academy.edge.studentmanager.models;

import com.academy.edge.studentmanager.enums.InstructorSpecialization;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "instructors")
@PrimaryKeyJoinColumn(name="id")
public class Instructor extends User{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    InstructorSpecialization specialization;
}
