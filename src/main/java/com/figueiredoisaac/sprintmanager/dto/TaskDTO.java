package com.figueiredoisaac.sprintmanager.dto;

import com.figueiredoisaac.sprintmanager.model.Task;
import com.figueiredoisaac.sprintmanager.model.TaskStatus;

public class TaskDTO {
	
	private String title;
	private String description;
	private Long timeExpended;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Task toTask() {
		Task task = new Task();
		task.setTitle(this.title);
		task.setDescription(this.description);
		task.setTimeExpended(this.timeExpended);
		task.setStatus(TaskStatus.Novo);
		return task;
	}
}