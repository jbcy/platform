package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PeanutDao;
import model.Peanut;
import utils.JdbcUtils;


/**
 * @author Jingbo Lin
 *
 */
public class PeanutDaoImpl implements PeanutDao {
	
	@Override
	public void insert(Peanut peanut) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			String sql = "INSERT INTO peanuts (id, user_id, points) VALUES ('" 
					+ peanut.getId() + "','"
					+ peanut.getUserId() + "', "
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

	@Override
	public Peanut find(String userId) {
		Statement statement = null;
		Peanut peanut = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM peanuts WHERE user_id = '" + userId +"'");
			while(rs.next()) {
				peanut = new Peanut(rs.getString(1), rs.getString(2), rs.getInt(3));
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

	@Override
	public void update(Peanut peanut) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("UPDATE peanuts SET points = " 
			+ peanut.getPoints() + " WHERE user_id = '" 
					+ peanut.getUserId() + "'");
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
