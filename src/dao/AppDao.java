package dao;

import java.util.List;

import model.App;

public interface AppDao {
	void insert(App app);
	App findByName(String name);
	List<App> findAll();
	void update(App app);
}
