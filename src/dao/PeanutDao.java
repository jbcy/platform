package dao;

import model.Peanut;

public interface PeanutDao {
	void insert(Peanut peanut);
	Peanut find(String userId);
	void update(Peanut peanut);
}
