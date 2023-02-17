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

import com.figueiredoisaac.sprintmanager.model.Backlog;
import com.figueiredoisaac.sprintmanager.model.Sprint;
import com.figueiredoisaac.sprintmanager.service.BacklogService;
import com.figueiredoisaac.sprintmanager.service.SprintService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {

  @Autowired
  private SprintService sprintService;
  
  @Autowired
  private BacklogService backlogService;

  @GetMapping
  @Operation(summary = "Retorna uma Sprint")
  public List<Sprint> getAllSprints() {
    return sprintService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Retorna uma Sprint especifica")
  public ResponseEntity<Sprint> getSprintById(@PathVariable Long id) {
    Optional<Sprint> sprint = Optional.of(sprintService.findById(id));
    if (sprint.isPresent()) {
      return ResponseEntity.ok(sprint.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @Operation(summary = "Cria uma nova Sprint")
  public Sprint createSprint(@RequestBody Sprint sprint) {
    return sprintService.save(sprint);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Atualiza uma Sprint")
  public ResponseEntity<Sprint> updateSprint(@PathVariable Long id, @RequestBody Sprint sprint) {
    Optional<Sprint> currentSprint = Optional.ofNullable(sprintService.findById(id));
    if (currentSprint.isPresent()) {
      Sprint updatedSprint = currentSprint.get();
      updatedSprint.setName(sprint.getName());
      updatedSprint.setDtBegin(sprint.getDtBegin());
      updatedSprint.setDtEnd(sprint.getDtEnd());
      updatedSprint.setDescription(sprint.getDescription());
      updatedSprint.setStatus(sprint.getStatus());
      
      return ResponseEntity.ok(sprintService.save(updatedSprint));
    }
    return ResponseEntity.notFound().build();
  }
  @PutMapping("/{idSprint}/backlog/{idBacklog}")
  @Operation(summary = "Adiciona um Backlog em uma sprint")
  public ResponseEntity<Sprint> addBacklog(@PathVariable Long idSprint, @PathVariable Long idBacklog ){
	  Optional<Sprint> currentSprint = Optional.ofNullable(sprintService.findById(idSprint));
	  Optional<Backlog> newBacklog = Optional.ofNullable(backlogService.findById(idBacklog));
	    if (newBacklog.isPresent()&&currentSprint.isPresent()) {
	    	Sprint updatedSprint = currentSprint.get();
	    	Backlog backlogToAdd = newBacklog.get();
	    	updatedSprint.addBacklog(backlogToAdd);
	    	return ResponseEntity.ok(sprintService.save(updatedSprint));
	    }
	    return ResponseEntity.notFound().build();
  }
  

  @DeleteMapping("/{id}")
  @Operation(summary = "Deleta uma Sprint especifica")
  public ResponseEntity<Void> deleteSprint(@PathVariable Long id) {
    Optional<Sprint> sprint = Optional.of(sprintService.findById(id));
    if (sprint.isPresent()) {
      sprintService.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}

