package service;

import java.sql.Date;
import java.util.List;

import model.App;
import model.Peanut;
import model.Record;
import model.User;
import model.UserApp;

public interface Transaction {
	void insertPeanut(String userId);
	void insertApp(App app);
	void insertUserApp(UserApp userApp);
	void insertRecord(Record record);
	
	
	Peanut findPeanut(String userId);
	App findAppByName(String name);
	List<App> findAllApp();
	List<Record> findRecordByTime(String userId, Date startDate, Date endDate);
	List<Record> findAllRecord(String userId);
	List<App> findUserApps(String userId);
	List<User> findAppUsers(String appId);
	
	void updatePeanut(Peanut peanut);
	void updateApp(App app);
	void updateRecord(Record record);
	
}
