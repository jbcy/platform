package model;

import java.util.Date;

public class UserApp {
	private String id;
	private String userId;
	private String appId;
	private Date joinDate;
	
	public UserApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserApp(String id, String userId, String appId, Date joinDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.appId = appId;
		this.joinDate = joinDate;
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}