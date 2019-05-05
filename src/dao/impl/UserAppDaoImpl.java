package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserAppDao;
import model.App;
import model.User;
import model.UserApp;
import utils.JdbcUtils;
/**
 * The implementation UserAppDao interface which allow user to access the "users_apps" table
 * in "jbcy" database and manipulate it.
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.UserApp
 */
public class UserAppDaoImpl implements UserAppDao {

	/**
	 * Add the user_app to the "users_apps" table. It will be called when user join the
	 * app for the first time
	 * @param userApp 	an instance of UserApp entity which store uploaded userApp data
	 * @see model.UserApp
	 * @since 1.0
	 */
	@Override
	public void insert(UserApp userApp) {
		
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("INSERT INTO users_apps (id, user_id, app_id, join_date) VALUES (null, "
					+ userApp.getUserId() + ", "
					+ userApp.getAppId() + ", '"
					+ new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(userApp.getJoinDate()) + "')");
			
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
	 * Retrieve App data from database by user's id 
	 * @param userId 	an integer that represent userId
	 * @return 			if there are relevant data in the database then return a list of
	 * 					App instance otherwise return null
	 * @see model.UserApp
	 * @since 1.0
	 */
	@Override
	public List<App> findByUser(int userId) {
		Statement statement = null;
		List<App> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users_apps WHERE user_id = " + userId);
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				App temp = new App();
				temp.setId(rs.getInt(3));
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
	 * Retrieve App data from database by user's id 
	 * @param appId 	an integer that represent appId
	 * @return 			if there are relevant data in the database then return a list of
	 * 					User instance otherwise return null
	 * @see model.UserApp
	 * @since 1.0
	 */
	@Override
	public List<User> findByApp(int appId) {
		Statement statement = null;
		List<User> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users_apps WHERE app_id = " + appId);
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(2));
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

	
		
	

}
