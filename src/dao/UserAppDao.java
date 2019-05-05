package dao;

import java.util.List;

import model.App;
import model.User;
import model.UserApp;
/**
 * UserAppDao is an interface which standardise the implement of database access 
 * to "users_apps" table. The implementation class should override all the function
 * which declare at the UserAppDao
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.UserApp
 */
public interface UserAppDao {
	void insert(UserApp userApp);
	List<App> findByUser(int userId);
	List<User> findByApp(int appId);
	
}
