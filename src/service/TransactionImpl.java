
package service;

import java.sql.Date;
import java.util.List;

import dao.AppDao;
import dao.PeanutDao;
import dao.RecordDao;
import dao.UserAppDao;
import model.App;
import model.Peanut;
import model.Record;
import model.User;
import model.UserApp;
import utils.DaoFactory;
import utils.GMethod;

/**
 * @author Jingbo Lin
 *
 */
public class TransactionImpl implements Transaction {
	private PeanutDao peanutDao = DaoFactory.getInstance().createDao("dao.impl.PeanutDaoImpl", PeanutDao.class);
	private AppDao appDao = DaoFactory.getInstance().createDao("dao.impl.AppDaoImpl", AppDao.class);
	private RecordDao recordDao = DaoFactory.getInstance().createDao("dao.impl.RecordDaoImpl", RecordDao.class);
	private UserAppDao userAppDao = DaoFactory.getInstance().createDao("dao.impl.UserAppDaoImpl", UserAppDao.class);
	
	
	
	@Override
	public void insertPeanut(String userId) {		
		peanutDao.insert(new Peanut(GMethod.makeID(), userId, 1000));	
	}


	@Override
	public void insertApp(App app) {
		appDao.insert(app);
		
	}

	@Override
	public void insertUserApp(UserApp userApp) {
		userAppDao.insert(userApp);
		
	}

	@Override
	public void insertRecord(Record record) {
		recordDao.insert(record);
		
	}
	
	@Override
	public Peanut findPeanut(String userId) {
		return peanutDao.find(userId);
	}

	@Override
	public App findAppByName(String name) {
		return appDao.findByName(name);
	}

	@Override
	public List<App> findAllApp() {
		return appDao.findAll();
	}

	@Override
	public List<Record> findRecordByTime(String userId, Date startDate, Date endDate) {
		return recordDao.findByTime(userId, startDate, endDate);
	}

	@Override
	public List<Record> findAllRecord(String userId) {
		return recordDao.findAll(userId);
	}

	@Override
	public List<App> findUserApps(String userId) {
		return userAppDao.findByUser(userId);
	}

	@Override
	public List<User> findAppUsers(String appId) {
		return userAppDao.findByApp(appId);
	}


	
	@Override
	public void updatePeanut(Peanut peanut) {
		peanutDao.update(peanut);
		
	}

	
	@Override
	public void updateApp(App app) {
		appDao.update(app);
	}

	@Override
	public void updateRecord(Record record) {
		
		
	}

}
