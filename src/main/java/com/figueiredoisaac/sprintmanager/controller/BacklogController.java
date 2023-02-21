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

import com.figueiredoisaac.sprintmanager.dto.BacklogDTO;
import com.figueiredoisaac.sprintmanager.model.Backlog;
import com.figueiredoisaac.sprintmanager.model.Sprint;
import com.figueiredoisaac.sprintmanager.model.Task;
import com.figueiredoisaac.sprintmanager.service.BacklogService;
import com.figueiredoisaac.sprintmanager.service.SprintService;
import com.figueiredoisaac.sprintmanager.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Backlogs", description = "Endpoints dos Backlogs")
@RequestMapping("/api/backlogs")
public class BacklogController {

	@Autowired
	private BacklogService backlogService;
	@Autowired
	private SprintService sprintService;

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
	public Backlog createBacklog(@Parameter(required = true) @Valid @RequestBody BacklogDTO backlogDTO) {
		Backlog backlog = backlogDTO.toBacklog();
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

	@PutMapping("/{idBacklog}/Sprint/{idSprint}")
	@Operation(summary = "Adiciona um Backlog em uma sprint")
	public ResponseEntity<Backlog> linkBacklogSprint(@PathVariable Long idBacklog, @PathVariable Long idSprint) {
		Optional<Sprint> currentSprint = Optional.ofNullable(sprintService.findById(idSprint));
		Optional<Backlog> backlogToAdd = Optional.ofNullable(backlogService.findById(idBacklog));
		if (backlogToAdd.isPresent() && currentSprint.isPresent()) {
			Sprint selectedSprint = currentSprint.get();
			Backlog selectedBacklog = backlogToAdd.get();
			selectedBacklog.addSprints(selectedSprint);
			return ResponseEntity.ok(backlogService.save(selectedBacklog));
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
