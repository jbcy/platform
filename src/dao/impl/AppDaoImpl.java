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

public class AppDaoImpl implements AppDao {

	@Override
	public void insert(App app) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			String sql = "INSERT INTO apps (id, name, description, users) VALUES ('" 
					+ app.getId() + "','"
					+ app.getName() + "', '"
					+ app.getDescription() + "', "
					+ app.getUsers() + ")";
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
	public App findByName(String name) {
		Statement statement = null;
		App app = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM apps WHERE name = '" + name +"'");
			while(rs.next()) {
				app = new App(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
				temp.setId(rs.getString(1));
				temp.setName(rs.getString(2));
				temp.setDescription(rs.getString(3));
				temp.setUsers(rs.getInt(4));
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
	public void update(App app) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			int result = statement.executeUpdate("UPDATE apps SET users = users + 1" 
			 + " WHERE id = '" 
					+ app.getId() + "'");
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
	public App findById(String id) {
		Statement statement = null;
		App app = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM apps WHERE id = '" + id +"'");
			while(rs.next()) {
				app = new App(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
