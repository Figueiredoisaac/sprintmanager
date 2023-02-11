package figueiredoisaac.com.sprintmanager.model;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="Tasks")
public class Task {
	
	@Id
	@Basic
	@Column(nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Long timeExpended;
	private TaskStatus status;
	
	@ManyToMany(mappedBy="tasks")
	private List<Backlog> backlogs;
	
	
	
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
	public List<Backlog> getBacklogs() {
		return backlogs;
	}
	public void addBacklog(Backlog backlog) {
		this.backlogs.add(backlog);
	}

	
}
