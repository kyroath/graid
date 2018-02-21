public class Group {
	private String description;
	private int maxNumberOfMembers;
	private int groupNo;
	private int currentCapacity;
	public Group(String description, int maxNumberOfMembers, int groupNo) {
		this.description = description;
		this.maxNumberOfMembers = maxNumberOfMembers;
		this.groupNo = groupNo;
		currentCapacity = 0;
	}
	
	public boolean isFull() {
		return getCurrentCapacity() < maxNumberOfMembers;
	}
	
	public int getMaxNumberOfMembers() {
		return maxNumberOfMembers;
	}
	
	public void increaseCapacity() {
		currentCapacity++;
	}
	
	public void decreaseCapacity() {
		currentCapacity--;
	}
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setMaxNumberOfMembers(int maxNumberOfMembers) {
		this.maxNumberOfMembers = maxNumberOfMembers;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "Group [description=" + description + "]";
	}
}