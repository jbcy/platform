package dao;

import java.util.List;

import model.App;

public interface AppDao {
	void insert(App app);
	App findByName(String name);
	App findById(String id);
	List<App> findAll();
	void update(App app);
}
