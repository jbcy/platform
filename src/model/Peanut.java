package model;

public class Peanut {
	
	private String id;
	private String userId;
	private int points = 1000;
	
	public Peanut() {
		super();
	}
	
	public Peanut(String id, String userId, int points) {
		super();
		this.id = id;
		this.userId = userId;
		this.points = points;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
