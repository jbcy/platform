package dao;

import java.util.List;

import model.App;
import model.User;
import model.UserApp;

public interface UserAppDao {
	void insert(UserApp userApp);
	List<App> findByUser(int userId);
	List<User> findByApp(int appId);
	
}
