package com.example.api.project.serviceImpl;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.project.model.TaskModel;
import com.example.api.project.service.TaskService;
import com.example.api.project.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void saveTask(TaskModel task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);
	}

	@Override
	public List<TaskModel> getTasks() {
		return taskRepository.findAll();
	}

	@Override
	public void deleteTaskById(Integer id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}

	@Override
	public void updateTaskById(TaskModel task, Integer id) {
		// TODO Auto-generated method stub
		TaskModel existingTask = taskRepository.findById(id).get();
		
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setStatus(task.getStatus());
		existingTask.setCreated_date(task.getCreated_date());
		existingTask.setUpdated_date(task.getUpdated_date());
		
		taskRepository.save(existingTask);
	}

}
