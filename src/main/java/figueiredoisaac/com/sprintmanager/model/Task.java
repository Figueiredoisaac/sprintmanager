package figueiredoisaac.com.sprintmanager.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
