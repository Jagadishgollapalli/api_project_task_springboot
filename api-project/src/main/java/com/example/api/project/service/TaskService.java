package com.example.api.project.service;
import java.util.List;

import com.example.api.project.model.TaskModel;

public interface TaskService {

	List<TaskModel> getTasks();

	void saveTask(TaskModel task);
	
	void deleteTaskById(Integer id);

	void updateTaskById(TaskModel task, Integer id);

}
