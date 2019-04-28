package model;
/**
 * Peanut bank entity
 * @author Jingbo Lin
 *
 */
public class Peanut {
	
	private int id;
	private int userId;
	private int points = 1000;
	
	public Peanut() {
		super();
	}
	
	
	public Peanut(int userId, int points) {
		super();
		this.userId = userId;
		this.points = points;
	}


	public Peanut(int id, int userId, int points) {
		super();
		this.id = id;
		this.userId = userId;
		this.points = points;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
