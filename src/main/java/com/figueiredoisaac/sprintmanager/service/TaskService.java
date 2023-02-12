package com.figueiredoisaac.sprintmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.figueiredoisaac.sprintmanager.model.Task;
import com.figueiredoisaac.sprintmanager.repository.TaskRepository;

public class TaskService {
	@Autowired
	private final TaskRepository taskRepository;

	private TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public Task findById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	public Task save(Task task) {
		return taskRepository.save(task);
	}

	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}
	
}
