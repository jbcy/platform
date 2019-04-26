package model;

import java.util.Date;

public class Record {
	private String id;
	private String userId;
	private String statement;
	private Date time;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Record(String id, String userId, String statement, Date time) {
		super();
		this.id = id;
		this.userId = userId;
		this.statement = statement;
		this.time = time;
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
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
