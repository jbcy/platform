package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dao.UserDao;
import it.cosenonjaviste.crypto.BCrypt;
import model.App;
import model.User;
import utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	
	
	@Override
	public String insert(User user) {
		Statement conne = null;
		String pass=null;
		if(repeatEmail(user.getEmail()))
		{
			return "Email already exists";
		}
		
		 pass=generatePass(user.getPassword());
		 user.setPassword(pass);
		
		try {
			conne = JdbcUtils.getConnection().createStatement();
			String sql = "INSERT INTO users ( name, email, password) VALUES ('" 
					+ user.getName() + "', '"
					+ user.getEmail() + "', '"
					+ user.getPassword() + "')";
			int result = conne.executeUpdate(sql);		
			
				return "Success";

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conne != null) {
				try {
					
					conne.close(); 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	return "Error";
	}


	@Override
	public int findId(String email)
	{
		Statement statement = null;
		 int theId=0;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT id FROM users WHERE email = '" + email +"'");
			while(rs.next()) 
			{
				theId=rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return theId;
	


	}
	
	
	@Override
	public boolean repeatEmail(String email) {
		Statement statement = null;
		try {
			statement = JdbcUtils.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT email FROM users WHERE email = '" + email +"'");
			if(rs.next()) {
				return true;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	
	
	private String generatePass(String password) 
	{
		
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		return hashed;
		
	}

	 
	 @Override
		public User validate(String password, String email) {
			Statement statement = null;
			User logedUser = null;
			if(email==null || password ==null) {
				return logedUser;
			}
			try {
				statement = JdbcUtils.getConnection().createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE email = '" + email +"'");
				while(rs.next()) {
					
					if(rs.getString(4)!=null)
					{
						if(BCrypt.checkpw(password,  rs.getString(4)))
						{
								
							logedUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
						}	
					}
					
				
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return logedUser;
		}
	 
	 
	 @Override
		public String updatePassword(String old, String newPass, int id) {
			Statement conne = null;
			 String pass=generatePass(newPass);

			
			try {
				conne = JdbcUtils.getConnection().createStatement();
				
				ResultSet rs = conne.executeQuery("SELECT password FROM users WHERE id = '" + id +"'");
				while(rs.next()) {
					
					if(rs.getString(1)!=null)
					{
						if(BCrypt.checkpw(old,  rs.getString(1)))
						{
							String sql = "UPDATE users SET password='" 
									+ pass +  "' where id='" + id +"'";
							int result = conne.executeUpdate(sql);	
							return "Success";
							
						}	
						else
						{
							return "Old password does not match";
						}
					}
					
				
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conne != null) {
					try {
						
						conne.close(); 
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		return "Error";
		}

	 @Override
		public boolean resetPassword(String email, String generated) {
			Statement conne = null;
			 String pass=generatePass(generated);

			
			try {
				conne = JdbcUtils.getConnection().createStatement();
				
				
			    String sql = "UPDATE users SET password='" 
									+ pass +  "' where email='" + email+"'";
			    int result = conne.executeUpdate(sql);
			    System.out.println(result);
			    if(result!=0)
			    {
			    return true;	
			    }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conne != null) {
					try {
						
						conne.close(); 
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		return false;
		}
	 
}
