package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDao;
import model.App;
import model.Record;
import utils.GMethod;
import utils.JdbcUtils;

public class RecordDaoImpl implements RecordDao {

	@Override
	public void insert(Record record) {

		Statement statement = null;
		try {
			
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("INSERT INTO records (id, user_id, type, statement, time) VALUES (null, "
					+ record.getUserId() + ", '"
					+ record.getType() + "', '"
					+ record.getStatement() + "', '"
					+ new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.getTime()) + "')");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public List<Record> findByTime(int userId, Date startDate, Date endDate) {
		Statement statement = null;
		List<Record> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM records WHERE user_id = " + userId 
					+ " AND time BETWEEN ‘" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate) 
					+ "' AND '" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endDate) + "'");
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				Record temp = new Record();
				temp.setId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setType(rs.getString(3));
				temp.setStatement(rs.getString(4));
				temp.setTime(rs.getDate(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public List<Record> findByType(int userId, String type) {
		Statement statement = null;
		List<Record> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM records WHERE user_id = " + userId 
					+ " AND type = ‘" + type + "'");
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				Record temp = new Record();
				temp.setId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setType(rs.getString(3));
				temp.setStatement(rs.getString(4));
				temp.setTime(rs.getDate(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	@Override
	public List<Record> findAll(int userId) {
		Statement statement = null;
		List<Record> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM records WHERE user_id = " + userId);
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				Record temp = new Record();
				temp.setId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setType(rs.getString(3));
				temp.setStatement(rs.getString(4));
				temp.setTime(rs.getDate(5));
				result.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public void update(Record record) {
		// TODO Auto-generated method stub

	}

	
	
}
