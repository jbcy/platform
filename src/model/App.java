package model;

import java.io.Serializable;

/**
 * The entity to store app's data
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 */
public class App implements Serializable{
	
	private int id;
	private int ownerId;
	private String name;
	private String description;
	private int users = 0;
	private int points;
	private int status;
	
	
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Constructor
	 * @param ownerId
	 * @param name
	 * @param description
	 * @param users
	 * @param points
	 * @param status
	 */
	public App(int ownerId, String name, String description, int users, int points, int status) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.description = description;
		this.users = users;
		this.points = points;
		this.status = status;
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param ownerId
	 * @param name
	 * @param description
	 * @param users
	 * @param points
	 * @param status
	 */
	public App(int id, int ownerId, String name, String description, int users, int points, int status) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.name = name;
		this.description = description;
		this.users = users;
		this.points = points;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	/**
	 * set function for app id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get function for owner id (user id)
	 * @return
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * 
	 * @param ownerId
	 */
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
