package dao;

import java.util.List;

import model.App;
/**
 * AppDao is an interface which standardise the implement of database access 
 * to "apps" table. The implementation class should override all the function
 * which declare at the AppDao
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.App
 */
public interface AppDao {
	void insert(App app);
	App findByName(String name);
	App findById(int id);
	List<App> findPublished();
	List<App> checkApps();
	List<App> wrongApps();
	void update(int id);
	void updateStatus(int id);
	void delete(int id);
	
}
