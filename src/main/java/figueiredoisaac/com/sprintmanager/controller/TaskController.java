package figueiredoisaac.com.sprintmanager.controller;

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

import figueiredoisaac.com.sprintmanager.model.Backlog;
import figueiredoisaac.com.sprintmanager.model.Task;
import figueiredoisaac.com.sprintmanager.service.TaskService;

@RestController
@RequestMapping("/api/backlogs/{backlogId}/tasks")
public class TaskController {
//	
//	  @Autowired
//	  private TaskService taskService;
//	  
//	  @GetMapping
//	  public List<Task> getAllTasks(@PathVariable Long backlogId, @PathVariable Long sprintId) {
//	    return taskService.findAllByBacklogId(backlogId);
//	  }
//	  
//	    @GetMapping("/{id}")
//	    public ResponseEntity<Task> getTaskById(@PathVariable Long backlogId, @PathVariable Long id) {
//	        Optional<Task> task = Optional.of(taskService.findByIdAndBacklogId(id, backlogId));
//	        if (task.isPresent()) {
//	            return ResponseEntity.ok(task.get());
//	        }
//	        return ResponseEntity.notFound().build();
//	    }
//	  
//	  @PostMapping
//	  public Task createTask(@PathVariable Long backlogId, @RequestBody Task task) {
//	    task.setBacklog(new Backlog(backlogId));
//	    return taskService.save(task);
//	  }
//	  @PutMapping("/{id}")
//	    public ResponseEntity<Task> updateTask(@PathVariable Long backlogId, @PathVariable Long id, @RequestBody Task task) {
//	        Optional<Task> currentTask = Optional.of(taskService.findByIdAndBacklogId(id, backlogId));
//	        if (currentTask.isPresent()) {
//	            Task updatedTask = currentTask.get();
//	            updatedTask.setName(task.getName());
//	            updatedTask.setDescription(task.getDescription());
//	            updatedTask.setStatus(task.getStatus());
//	            return ResponseEntity.ok(taskService.save(updatedTask));
//	        }
//	        return ResponseEntity.notFound().build();
//	    }
//	  
//	  @DeleteMapping("/{id}")
//	    public ResponseEntity<Void> deleteTask(@PathVariable Long backlogId, @PathVariable Long id) {
//	        Optional<Task> task = Optional.of(taskService.findByIdAndBacklogId(id, backlogId));
//	        if (task.isPresent()) {
//	            taskService.deleteById(id);
//	            return ResponseEntity.ok().build();
//	        }
//	        return ResponseEntity.notFound().build();
//	    }
	  }
