package com.academy.edge.studentmanager.repositories;

import com.academy.edge.studentmanager.models.Activity;
import com.academy.edge.studentmanager.models.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository <Activity,String> {

    List<Activity> findActivityByStudentId(String studentId);
}
