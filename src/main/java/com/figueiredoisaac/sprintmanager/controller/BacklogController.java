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
import com.figueiredoisaac.sprintmanager.service.BacklogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/backlogs")
public class BacklogController {

	@Autowired
	private BacklogService backlogService;

	@GetMapping
	@Operation(summary = "Retorna uma Lista de Backlog")
	public List<Backlog> getAllBacklogs() {
		return backlogService.findAll();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Retorna um Backlog especifico")
	public ResponseEntity<Backlog> getBacklogById(
			@Parameter(description = "ID do Backlog", required = true) @PathVariable Long id) {
		Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
		if (backlog.isPresent()) {
			return ResponseEntity.ok(backlog.get());
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@Operation(summary = "Cria um novo Backlog")
	public Backlog createBacklog(
			@Parameter(required = true) @Valid @RequestBody Backlog backlog) {
		return backlogService.save(backlog);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualiza um backlog já existente")
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
	@Operation(summary = "Deleta um backlog existente")
	public ResponseEntity<Void> deleteBacklog(@PathVariable Long id) {
		Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
		if (backlog.isPresent()) {
			backlogService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
