package dao;


import java.util.Date;
import java.util.List;

import model.Record;

public interface RecordDao {
	void insert(Record record);
	List<Record> findByTime(int userId, Date startDate, Date endDate);
	List<Record> findByType(int userId, String type);
	List<Record> findAll(int userId);
	void update(Record record);
}
