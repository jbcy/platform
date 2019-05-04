package dao;

import model.User;



public interface UserDao {
	String insert(User user);
	boolean repeatEmail(String email);
	User validate(String password, String email);
	int findId(String email);
	String updatePassword(String old, String newPass, int id) ;
}
