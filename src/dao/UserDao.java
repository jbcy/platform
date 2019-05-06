package dao;

import model.User;
/**
 * UserDao is an interface which standardise the implement of database access 
 * to "users" table. The implementation class should override all the function
 * which declare at the UserDao
 * @author Claudia Gomez
 * @version %I%, %G%
 * @since 1.0
 * @see model.User
 */
public interface UserDao {
	String insert(User user);
	boolean repeatEmail(String email);
	User validate(String password, String email);

	User findByEmail(String email);
	String updatePassword(String old, String newPass, int id) ;

	boolean resetPassword(String email, String generated);

}
