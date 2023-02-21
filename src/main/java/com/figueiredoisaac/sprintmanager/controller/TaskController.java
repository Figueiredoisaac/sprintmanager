package com.figueiredoisaac.sprintmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figueiredoisaac.sprintmanager.dto.TaskDTO;
import com.figueiredoisaac.sprintmanager.model.Backlog;
import com.figueiredoisaac.sprintmanager.model.Task;
import com.figueiredoisaac.sprintmanager.service.BacklogService;
import com.figueiredoisaac.sprintmanager.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag( name = "Tasks", description = "Endpoints das Tasks")
@RequestMapping("/api/tasks")
public class TaskController {

	  @Autowired
	  private TaskService taskService;
	  @Autowired
	  private BacklogService backlogService;

	  @GetMapping
	  @Operation(summary = "Retorna uma Task")
	  public List<Task> getAllTasks() {
	    return taskService.findAll();
	  }

	  @GetMapping("/{id}")
	  @Operation(summary = "Retorna uma Task especifica")
	  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	    Optional<Task> task = Optional.of(taskService.findById(id));
	    if (task.isPresent()) {
	      return ResponseEntity.ok(task.get());
	    }
	    return ResponseEntity.notFound().build();
	  }

	  @PostMapping("/{idBacklog}")
	  @Operation(summary = "Cria uma nova Task")
	  public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO, @PathVariable Long idBacklog) {
		  Optional<Backlog> backlogToAdd = Optional.ofNullable(backlogService.findById(idBacklog));
		  if (backlogToAdd.isPresent()) {
			  Backlog backlog = backlogToAdd.get();
			  Task task = taskDTO.toTask();
			  task.setBacklog(backlog);
			  return ResponseEntity.ok(taskService.save(task));
		  }
		  return ResponseEntity.notFound().build();
	  }

	  @PutMapping("/{id}")
	  @Operation(summary = "Atualiza uma Task")
	  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
	    Optional<Task> currentTask = Optional.ofNullable(taskService.findById(id));
	    if (currentTask.isPresent()) {
	      Task updatedTask = currentTask.get();
	      updatedTask.setTimeExpended(task.getTimeExpended());
	      updatedTask.setDescription(task.getDescription());
	      updatedTask.setStatus(task.getStatus());
	      
	      return ResponseEntity.ok(taskService.save(updatedTask));
	    }
	    return ResponseEntity.notFound().build();
	  }
	  
	  @DeleteMapping("/{id}")
	  @Operation(summary = "Deleta uma Task especifica")
	  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	    Optional<Task> task = Optional.of(taskService.findById(id));
	    if (task.isPresent()) {
	      taskService.deleteById(id);
	      return ResponseEntity.ok().build();
	    }
	    return ResponseEntity.notFound().build();
	  }
	  }
