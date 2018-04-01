import java.util.ArrayList;
import java.util.ListIterator;

public class Group {
	// Properties
	ArrayList<Member> members;

	// Constructor
	public Group() {
		members = new ArrayList<Member>();
	}

	// Methods

	public void add(Member a) {
		members.add(a);
	}

	public ArrayList<String> findCommons() {

		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		ArrayList<String> commons = new ArrayList<String>();
		for (int i = 0; i < members.size(); i++) {
			lists.add(members.get(i).getTags());
		}

		commons.addAll(lists.get(1));
		ListIterator<ArrayList<String>> iter = lists.listIterator();
		while (iter.hasNext()) {
			commons.retainAll(iter.next());
		}
		return commons;
	}
	
	public Member getMember(int i) 
	{
		return members.get(i);
	}
	
	public int size() 
	{
		return members.size();
	}

	public String toString() {
		return members.toString();
	}
}