package dao;

import model.User;



public interface UserDao {
	 String insert(User user);
	boolean repeatEmail(String email);
	User validate(String password, String email);
	public int findId(String email);
	public String updatePassword(String old, String newPass, int id) ;
	boolean resetPassword(String email, String generated);
}
