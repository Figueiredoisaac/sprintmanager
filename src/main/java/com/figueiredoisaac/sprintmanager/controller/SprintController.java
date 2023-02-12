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

import com.figueiredoisaac.sprintmanager.model.Sprint;
import com.figueiredoisaac.sprintmanager.service.SprintService;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {

  @Autowired
  private SprintService sprintService;

  @GetMapping
  public List<Sprint> getAllSprints() {
    return sprintService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sprint> getSprintById(@PathVariable Long id) {
    Optional<Sprint> sprint = Optional.of(sprintService.findById(id));
    if (sprint.isPresent()) {
      return ResponseEntity.ok(sprint.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public Sprint createSprint(@RequestBody Sprint sprint) {
    return sprintService.save(sprint);
  }

  @PutMapping("/{id}")
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

//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> deleteSprint(@PathVariable Long id) {
//    Optional<Sprint> sprint = sprintService.findById(id);
//    if (sprint.isPresent()) {
//      sprintService.deleteById(id);
//      return ResponseEntity.ok().build();
//    }
//    return ResponseEntity.notFound().build();
//  }
}

