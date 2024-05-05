package com.academy.edge.studentmanager.models;

import com.academy.edge.studentmanager.enums.Course;
import com.academy.edge.studentmanager.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "students")
@PrimaryKeyJoinColumn(name="id")
public class Student extends User{

    @Column
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Course course;

    @Column(nullable = false)
    String registration;

    @Column(nullable = false)
    private String phone;

    @Column()
    private String secondaryPhone;

    @Column(nullable = false)
    private int period;

    @Column(nullable = false)
    private String entryPeriod;

    @Column(nullable = false)
    private int studentGroup;

    @Column(nullable = false)
    private Date entryDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+ Role.STUDENT.name()));
    }

    @Override
    public String getDtype() {
        return "Student";
    }
}
