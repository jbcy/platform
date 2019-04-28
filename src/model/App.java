package model;

public class App {
	private int id;
	private String name;
	private String description;
	private int users = 0;
	private int points;
	
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	public App(String name, String description, int users, int points) {
		super();
		this.name = name;
		this.description = description;
		this.users = users;
		this.points = points;
	}





	public App(int id, String name, String description, int users, int points) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
		this.points = points;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}





	public int getPoints() {
		return points;
	}





	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
}
