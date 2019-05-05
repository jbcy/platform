package dao;

import model.Peanut;
/**
 * PeanutDao is an interface which standardise the implement of database access 
 * to "peanuts" table. The implementation class should override all the function
 * which declare at the PeanutDao
 * @author Jingbo Lin
 * @version %I%, %G%
 * @since 1.0
 * @see model.Peanut
 */
public interface PeanutDao {
	void insert(Peanut peanut);
	Peanut find(int userId);
	void update(Peanut peanut);
}
