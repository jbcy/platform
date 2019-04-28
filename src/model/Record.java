package model;

import java.util.Date;

public class Record {
	private int id;
	private int userId;
	private String statement;
	private Date time;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Record(int userId, String statement, Date time) {
		super();
		this.userId = userId;
		this.statement = statement;
		this.time = time;
	}

	public Record(int id, int userId, String statement, Date time) {
		super();
		this.id = id;
		this.userId = userId;
		this.statement = statement;
		this.time = time;
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
