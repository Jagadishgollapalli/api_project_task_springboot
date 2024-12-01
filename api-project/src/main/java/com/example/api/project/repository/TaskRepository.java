package com.example.api.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.project.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel,Integer> {

}
