public class Tag {
	private String description;
	private int credentialOrskillsTag; // 0 for credential, 1 for normal tags.
	
	public Tag(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "Tag [description=" + description + "]";
	}
}
