package com.academy.edge.studentmanager.repositories;

import com.academy.edge.studentmanager.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, String>{
    Optional<Subject> findSubjectByCode(String code);
}
