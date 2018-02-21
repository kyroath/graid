import java.util.ArrayList;

public class section {
	private ArrayList<Group> section;
	
	
	public void addGroup(String description, int maxNumberOfMembers, int groupNo) {
		section.add(new Group(description, maxNumberOfMembers, groupNo));
	}
	
	public void removeGroup(String desciptionToRemove) {
		for (int i = 0; i < section.size(); i++) {
			if (section.get(i).getDescription().equals(desciptionToRemove)) {
				section.remove(i);
			}
		}
	}
	
	
	public void findSection() {
		
	}
	
	public void listSections() {
		
	}
	
	public void searchGroup() {
		
	}
	
	
}
