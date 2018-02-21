public class stickyMessage {
	private String description;
	
	public stickyMessage(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Task [description=" + description+ "]";
	}
}