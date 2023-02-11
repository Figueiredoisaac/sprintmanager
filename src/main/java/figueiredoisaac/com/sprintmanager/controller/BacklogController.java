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
import figueiredoisaac.com.sprintmanager.repository.BacklogRepository;
import figueiredoisaac.com.sprintmanager.service.BacklogService;

@RestController
@RequestMapping("/api/backlogs")
public class BacklogController {
	
	  @Autowired
	  private BacklogService backlogService;
	  
	  @GetMapping
	  public List<Backlog> getAllBacklogs() {
	    return backlogService.findAll();
	  }
	  
	    @GetMapping("/{id}")
	    public ResponseEntity<Backlog> getBacklogById(@PathVariable Long id) {
	        Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
	        if (backlog.isPresent()) {
	            return ResponseEntity.ok(backlog.get());
	        }
	        return ResponseEntity.notFound().build();
	    }
	  
	  @PostMapping
	  public Backlog createBacklog(@RequestBody Backlog backlog) {
	    return backlogService.save(backlog);
	  }
	  @PutMapping("/{id}")
	    public ResponseEntity<Backlog> updateBacklog(@PathVariable Long id, @RequestBody Backlog backlog) {
	        Optional<Backlog> currentBacklog = Optional.of(backlogService.findById(id));
	        if (currentBacklog.isPresent()) {
	            Backlog updatedBacklog = currentBacklog.get();
	            updatedBacklog.setName(backlog.getName());
	            updatedBacklog.setUserStory(backlog.getUserStory());
	            return ResponseEntity.ok(backlogService.save(updatedBacklog));
	        }
	        return ResponseEntity.notFound().build();
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBacklog(@PathVariable Long id) {
	        Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
	        if (backlog.isPresent()) {
	            backlogService.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
	  }
