package com.academy.edge.studentmanager.repositories;

import com.academy.edge.studentmanager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByEmail(String email);
}
