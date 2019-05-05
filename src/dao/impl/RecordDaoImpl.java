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
/**
 * The implementation RecordDao interface which allow user to access the "records" table
 * in "jbcy" database and manipulate it.
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.Record
 */
public class RecordDaoImpl implements RecordDao {

	/**
	 * Add a Record to the "records" table. It will be called when user has any new activity
	 * @param peanut 	an instance of Peanut entity which store uploaded peanut data
	 * @see model.Record
	 * @since 1.0
	 */
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

	/**
	 * Retrieve records data from database by searching its userId and the time section 
	 * @param userId 	an integer that represent userId
	 * @param startDate	start date of time section
	 * @param endDate	end date of time section
	 * @return 		if there are relevant records in the database then return a list of
	 * 				Record instance otherwise return null
	 * @see model.Record
	 * @since 1.0
	 */
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

	/**
	 * Retrieve records data from database by searching its userId and its type 
	 * @param userId 	an integer that represent userId
	 * @param type		a String that represent record type
	 * @return 		if there are relevant records in the database then return a list of
	 * 				Record instance otherwise return null
	 * @see model.Record
	 * @since 1.0
	 */
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
	
	/**
	 * Retrieve all records data from database
	 * @return 		if there is any records in the database then return a list of
	 * 				Record instance otherwise return null
	 * @see model.Record
	 * @since 1.0
	 */
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
