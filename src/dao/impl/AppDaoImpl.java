package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AppDao;
import model.App;
import model.Peanut;
import utils.JdbcUtils;
/**
 * The implementation AppDao interface which allow user to access the "apps" table
 * in "jbcy" database and manipulate it.
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.App
 */
public class AppDaoImpl implements AppDao {

	/**
	 * Add the app to the "apps" table. It will be called when user upload an app
	 * @param app 	an instance of App entity which store uploaded app data
	 * @see model.App
	 * @since 1.0
	 */
	@Override
	public void insert(App app) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			String sql = "INSERT INTO apps (id, owner_id, name, description, users, points) VALUES (null, "
					+ app.getOwnerId() + ", '" 
					+ app.getName() + "', '"
					+ app.getDescription() + "', "
					+ app.getUsers() + ", "
					+ app.getPoints() + ")";
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
	 * Retrieve app data from database by searching its name 
	 * @param app 	an instance of App entity which store uploaded app data
	 * @return 		if there is already an app in the database then return an 
	 * 				app instance otherwise return null
	 * @see model.App
	 * @since 1.0
	 */
	@Override
	public App findByName(String name) {
		Statement statement = null;
		App app = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM apps WHERE name = '" + name +"'");
			while(rs.next()) {
				app = new App(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
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
		return app;
	}

	/**
	 * Retrieve all app data from database 
	 * @return 		if there are already some apps in the database then return a list 
	 * 				apps instance otherwise return null
	 * @see model.App
	 * @since 1.0
	 */
	@Override
	public List<App> findAll() {
		Statement statement = null;
		List<App> result = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM apps");
//			int column = rs.getMetaData().getColumnCount();
			result = new ArrayList<>();
			while (rs.next()) {
				App temp = new App();
				temp.setId(rs.getInt(1));
				temp.setOwnerId(rs.getInt(2));
				temp.setName(rs.getString(3));
				temp.setDescription(rs.getString(4));
				temp.setUsers(rs.getInt(5));
				temp.setPoints(rs.getInt(6));
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
	 * update specific app data from database by its id
	 * @param id 	an integer that represent app's id
	 * @see model.App
	 * @since 1.0
	 */
	@Override
	public void update(int id) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("UPDATE apps SET users = users + 1" 
			 + " WHERE id = " 
					+ id);
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
	 * find specific app data from database by its id
	 * @param id 	an integer that represent app's id
	 * @return 		if there is already an app have the same id
	 * 				in the database then return an 
	 * 				app instance otherwise return null
	 * @see model.App
	 * @since 1.0
	 */
	@Override
	public App findById(int id) {
		Statement statement = null;
		App app = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM apps WHERE id = " + id);
			while(rs.next()) {
				app = new App(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
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
		return app;
	}

}
