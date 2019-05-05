package dao;


import java.util.Date;
import java.util.List;

import model.Record;
/**
 * RecordDao is an interface which standardise the implement of database access 
 * to "records" table. The implementation class should override all the function
 * which declare at the RecordDao
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.Record
 */
public interface RecordDao {
	void insert(Record record);
	List<Record> findByTime(int userId, Date startDate, Date endDate);
	List<Record> findByType(int userId, String type);
	List<Record> findAll(int userId);
	void update(Record record);
}
