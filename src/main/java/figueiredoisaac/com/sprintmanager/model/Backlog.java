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
@Table (name="Backlogs")
public class Backlog {

	@Id
	@Column(unique=true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long valor;
	private Long gut;
	private String userStory;
	
	@ManyToMany
	private List<Task> tasks;
	
	@ManyToMany
	private List<Sprint> sprints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getGut() {
		return gut;
	}

	public void setGut(Long gut) {
		this.gut = gut;
	}

	public String getUserStory() {
		return userStory;
	}

	public void setUserStory(String userStory) {
		this.userStory = userStory;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public List<Sprint> getSprints() {
		return sprints;
	}

	public void addSprints(Sprint sprint) {
		this.sprints.add(sprint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
