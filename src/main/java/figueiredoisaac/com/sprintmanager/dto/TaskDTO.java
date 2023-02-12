package figueiredoisaac.com.sprintmanager.dto;

import figueiredoisaac.com.sprintmanager.model.Task;
import figueiredoisaac.com.sprintmanager.model.TaskStatus;

public class TaskDTO {
	private Long id;
	private String description;
	private Long timeExpended;
	private TaskStatus status;
	
	public TaskDTO() { }
	
	public TaskDTO(Task task) {
		this.id = task.getId();
		this.description = task.getDescription();
		this.timeExpended = task.getTimeExpended();
		this.status = task.getStatus();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTimeExpended() {
		return timeExpended;
	}
	public void setTimeExpended(Long timeExpended) {
		this.timeExpended = timeExpended;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public Task toTask() {
		Task task = new Task();
		task.setId(this.id);
		task.setDescription(this.description);
		task.setTimeExpended(this.timeExpended);
		task.setStatus(this.status);
		
		return task;
	}
}