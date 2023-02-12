package figueiredoisaac.com.sprintmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import figueiredoisaac.com.sprintmanager.service.BacklogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/backlogs")
@Api(value = "Backlog Management System")
public class BacklogController {
	
	  @Autowired
	  private BacklogService backlogService;
	  
	  @GetMapping
	  @ApiOperation(value = "View a list of backlogs", response = List.class)
	  @ApiResponses(value = {
			  @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			  @ApiResponse(code = 201, message = "Successfully created resource"),
			  @ApiResponse(code = 204, message = "Successfully updated resource"),
			  @ApiResponse(code = 400, message = "Bad request"),
			  @ApiResponse(code = 401, message = "Unauthorized"),
			  @ApiResponse(code = 403, message = "Forbidden"),
			  @ApiResponse(code = 404, message = "Resource not found"),
			  @ApiResponse(code = 500, message = "Internal server error")
	            })
	  public List<Backlog> getAllBacklogs() {
	    return backlogService.findAll();
	  }
	  
	    @GetMapping("/{id}")
	    @ApiOperation(value = "Get a backlog by ID", response = Backlog.class)
	    @ApiResponses(value = {
	    		  @ApiResponse(code = 200, message = "Successfully retrieved resource"),
				  @ApiResponse(code = 201, message = "Successfully created resource"),
				  @ApiResponse(code = 204, message = "Successfully updated resource"),
				  @ApiResponse(code = 400, message = "Bad request"),
				  @ApiResponse(code = 401, message = "Unauthorized"),
				  @ApiResponse(code = 403, message = "Forbidden"),
				  @ApiResponse(code = 404, message = "Resource not found"),
				  @ApiResponse(code = 500, message = "Internal server error")
	            })
	    public ResponseEntity<Backlog> getBacklogById(@ApiParam(value = "ID do Backlog", required = true) @PathVariable Long id) {
	        Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
	        if (backlog.isPresent()) {
	            return ResponseEntity.ok(backlog.get());
	        }
	        return ResponseEntity.notFound().build();
	    }
	  
	  @PostMapping
	  @ApiOperation(value = "Criar um backlog")
	  @ApiResponses(value = {
			  @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			  @ApiResponse(code = 201, message = "Successfully created resource"),
			  @ApiResponse(code = 204, message = "Successfully updated resource"),
			  @ApiResponse(code = 400, message = "Bad request"),
			  @ApiResponse(code = 401, message = "Unauthorized"),
			  @ApiResponse(code = 403, message = "Forbidden"),
			  @ApiResponse(code = 404, message = "Resource not found"),
			  @ApiResponse(code = 500, message = "Internal server error")
	            })
	  public Backlog createBacklog( @ApiParam(value = "Informações do Backlog a ser criada", required = true)
	    @Valid @RequestBody Backlog backlog) {
	    return backlogService.save(backlog);
	  }
	  @PutMapping("/{id}")
	  @ApiOperation(value = "Update a backlog")
	  @ApiResponses(value = {
			  @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			  @ApiResponse(code = 201, message = "Successfully created resource"),
			  @ApiResponse(code = 204, message = "Successfully updated resource"),
			  @ApiResponse(code = 400, message = "Bad request"),
			  @ApiResponse(code = 401, message = "Unauthorized"),
			  @ApiResponse(code = 403, message = "Forbidden"),
			  @ApiResponse(code = 404, message = "Resource not found"),
			  @ApiResponse(code = 500, message = "Internal server error")
	            })
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
	  @ApiOperation(value = "Delete a backlog")
	  @ApiResponses(value = {
			  @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			  @ApiResponse(code = 201, message = "Successfully created resource"),
			  @ApiResponse(code = 204, message = "Successfully updated resource"),
			  @ApiResponse(code = 400, message = "Bad request"),
			  @ApiResponse(code = 401, message = "Unauthorized"),
			  @ApiResponse(code = 403, message = "Forbidden"),
			  @ApiResponse(code = 404, message = "Resource not found"),
			  @ApiResponse(code = 500, message = "Internal server error")
	            })
	    public ResponseEntity<Void> deleteBacklog(@PathVariable Long id) {
	        Optional<Backlog> backlog = Optional.of(backlogService.findById(id));
	        if (backlog.isPresent()) {
	            backlogService.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
	  }
