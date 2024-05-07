package com.academy.edge.studentmanager.repositories;

import com.academy.edge.studentmanager.models.Grades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesRepository extends CrudRepository<Grades, String>{
    List<Grades> findByStudentId(String studentId);
}
