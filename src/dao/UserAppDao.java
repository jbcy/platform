package dao;

import java.util.List;

import model.App;
import model.User;
import model.UserApp;

public interface UserAppDao {
	void insert(UserApp userApp);
	List<App> findByUser(String userId);
	List<User> findByApp(String appId);
	
}
