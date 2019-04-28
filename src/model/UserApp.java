package model;

import java.util.Date;

public class UserApp {
	private int id;
	private int userId;
	private int appId;
	private Date joinDate;
	
	public UserApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserApp(int id, int userId, int appId, Date joinDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.appId = appId;
		this.joinDate = joinDate;
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



	public int getAppId() {
		return appId;
	}



	public void setAppId(int appId) {
		this.appId = appId;
	}



	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}