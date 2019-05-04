package model;

public class App {
	private int id;
	private int ownerId;
	private String name;
	private String description;
	private int users = 0;
	private int points;
	
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public App(int ownerId, String name, String description, int users, int points) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.description = description;
		this.users = users;
		this.points = points;
	}


	public App(int id, int ownerId, String name, String description, int users, int points) {
		super();
		this.id = id;
		this.ownerId = ownerId;
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


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
