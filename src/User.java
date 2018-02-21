import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private ArrayList<Task> taskList;
	private ArrayList<Tag> tagList;
	private ArrayList<Group> groupList;
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	public void listTasks() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i));
		}
	}
	
	public Task searchForTask(Task task) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(task.getDescription())) {
				return taskList.get(i);
			}
		}
		return null;	
	}
	
	public void orderTasks(ArrayList<Task> taskList) {
		//todo...
	}
	

	
	public void searchForGroup() {
		//todo...
	}
	
	public void getSimilarity(User user, ArrayList<User> userList) {
		//todo...
	}
	
	public void editTask(String oldDescription, String newDescription) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(oldDescription)) {
				taskList.get(i).setDescription(newDescription);
			}
		}
	}
	
	public void removeTask(String desciptionToRemove) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(desciptionToRemove)) {
				taskList.remove(i);
			}
		}
	}

	public void addTag(String description, boolean isAllowed) {
		if(isAllowed) tagList.add(new Tag(description));
	}
	
	public void vote() {
		//todo...
	}
	
	public void listGroups() {
		//todo...
	}
	
	public void joinGroup() {
		//todo...
	}
	
	public void quitGroup() {
		//todo...
	}
	
	public void sendMessages(String message) throws UnknownHostException, IOException{
	     Socket sock = new Socket("127.0.0.1", 5554);     
	     OutputStream ostream = sock.getOutputStream();                 
	     DataOutputStream dos = new DataOutputStream(ostream);
	     dos.writeBytes(message);                                                         
	     dos.close();                            
	     ostream.close();   
	     sock.close();
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
}
