public class Task {
	private String description;
	private int dueDate;
	private int priority;
	private boolean isCompleted;
	
	public Task(String description, int dueDate, int priority) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		isCompleted = false;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDueDate() {
		return dueDate;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean isCompleted() {
		return isCompleted;
	}
	
	@Override
	public String toString() {
		return "Task [description=" + description + ", dueDate=" + dueDate + ", priority=" + priority + "]";
	}
}

	