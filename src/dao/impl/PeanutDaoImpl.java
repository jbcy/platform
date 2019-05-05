package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PeanutDao;
import model.Peanut;
import utils.JdbcUtils;


/**
 * The implementation PeanutDao interface which allow user to access the "peanuts" table
 * in "jbcy" database and manipulate it.
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.Peanut
 */
public class PeanutDaoImpl implements PeanutDao {
	
	/**
	 * Add a peanut bank to the "peanuts" table. It will be called when user finish registration
	 * @param peanut 	an instance of Peanut entity which store uploaded peanut data
	 * @see model.Peanut
	 * @since 1.0
	 */
	@Override
	public void insert(Peanut peanut) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			String sql = "INSERT INTO peanuts (id, user_id, points) VALUES (null, " 
					+ peanut.getUserId() + ", "
					+ peanut.getPoints() + ")";
			int result = statement.executeUpdate(sql);
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

	}
	
	/**
	 * Retrieve peanut data from database by searching its user_id 
	 * @param userId 	an integer which represent userId
	 * @return 			if there is already a peanut in the database then return a 
	 * 					Peanut instance otherwise return null
	 * @see model.Peanut
	 * @since 1.0
	 */
	@Override
	public Peanut find(int userId) {
		Statement statement = null;
		Peanut peanut = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM peanuts WHERE user_id = " + userId);
			while(rs.next()) {
				peanut = new Peanut(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
			rs.close();
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
		return peanut;
	}

	
	/**
	 * update specific peanut data from database by its id
	 * @param peanut 	an instance that represent peanut which need to be update
	 * @see model.Peanut
	 * @since 1.0
	 */
	@Override
	public void update(Peanut peanut) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("UPDATE peanuts SET points = " 
			+ peanut.getPoints() + " WHERE user_id = " 
					+ peanut.getUserId());
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
		
	}
	
}
