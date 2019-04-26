package model;

public class App {
	private String id;
	private String name;
	private int users = 0;
	
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	public App(String id, String name, int users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}
	
	
	
}
