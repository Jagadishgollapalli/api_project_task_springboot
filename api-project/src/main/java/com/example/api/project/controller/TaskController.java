package com.example.api.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.project.model.TaskModel;
import com.example.api.project.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/create-task")
	public ResponseEntity<String> createTask(@Valid @RequestBody TaskModel task, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(result.getAllErrors().get(0).getDefaultMessage());
			}
			taskService.saveTask(task);
			return ResponseEntity.ok("Task created successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error creating task: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete-task/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable("id") Integer id) {
		try {
			taskService.deleteTaskById(id);
			return ResponseEntity.ok("Task deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Cant find task with" + id + e.getMessage());
		}
	}

	@PutMapping("/update-task/{id}")
	public ResponseEntity<String> updateTask(@RequestBody TaskModel task, @PathVariable("id") Integer id) {
		taskService.updateTaskById(task, id);
		return ResponseEntity.ok("Task Updated Successfully");
	}

	@GetMapping("/all-tasks")
	public ResponseEntity<List<TaskModel>> getTasks() {
		try {
			List<TaskModel> getAllTasks = taskService.getTasks();
			return ResponseEntity.ok(getAllTasks);
		} catch (Exception e) {
			List<TaskModel> emptyList = new ArrayList<>();
			return ResponseEntity.status(500).body(emptyList);
		}
	}
}