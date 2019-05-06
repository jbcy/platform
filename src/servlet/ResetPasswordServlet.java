package servlet;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import service.Mail;

import utils.GeneratePass;


/**
 * @author Claudia Gomez
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			getServletContext().getRequestDispatcher("/jsp/resetPassword.jsp").include(request, response);
		
	}
    /**
     * will send an email with the new generated password, verifying that the email provided belongs to a user in the database
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        
	        String email = request.getParameter("email");
	        if(email.length()!=0)
	        {
	        	 String generatedPass= GeneratePass.generate();
	  	       UserDaoImpl reset = new UserDaoImpl();
	  	        boolean answer= reset.resetPassword(email, generatedPass);
	  	       if(answer==true)
	  	       {
	  	    	 Mail.send(email, "Reset password", "Hi!  Here is the new password, Please change it once you login.  Password: "+ generatedPass);
	  	    	request.setAttribute("messages", "Success! we send an email with your new password.");
	  	    	getServletContext().getRequestDispatcher("/jsp/resetPassword.jsp").include(request, response);
	  	       }
	  	     else
		        {
		        	 request.setAttribute("messages", "There was a problem , please check that your University Email ID is correct");
				getServletContext().getRequestDispatcher("/jsp/resetPassword.jsp").include(request, response);
		        }
	  	       	
	        }
	        else
	        {
	        	 request.setAttribute("messages", "Please type your email");
			getServletContext().getRequestDispatcher("/jsp/resetPassword.jsp").include(request, response);
	        }
	      
	       
	}

}
