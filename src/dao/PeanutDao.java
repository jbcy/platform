package dao;

import model.Peanut;
/**
 * 
 * @author Jingbo Lin
 *
 */
public interface PeanutDao {
	void insert(Peanut peanut);
	Peanut find(int userId);
	void update(Peanut peanut);
}
