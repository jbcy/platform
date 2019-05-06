package service;

import java.sql.Date;
import java.util.List;

import model.App;
import model.Peanut;
import model.Record;
import model.User;
import model.UserApp;

public interface Transaction {
	void insertPeanut(int userId);
	void insertApp(App app);
	void insertUserApp(UserApp userApp);
	void insertRecord(Record record);
	
	
	Peanut findPeanut(int userId);
	App findAppByName(String name);
	App findAppById(int id);
	List<App> findPublished();
	List<App> checkApps();
	List<App> wrongApps();
	List<Record> findRecordByTime(int userId, Date startDate, Date endDate);
	List<Record> findRecordByType(int userId, String type);
	List<Record> findAllRecord(int userId);
	List<App> findUserApps(int userId);
	List<User> findAppUsers(int appId);
	
	void updatePeanut(Peanut peanut);
	void updateApp(int id);
	void updateAppStatus(int id);
	void updateRecord(Record record);
	
	void deleteApp(int id);
}
