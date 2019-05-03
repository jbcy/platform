package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.UserDaoImpl;
import model.App;
import model.AppType;
import model.Peanut;
import model.Record;
import model.User;
import service.TransactionImpl;

public class LoginHandler extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userEmail = request.getParameter("lemail");
		String password = request.getParameter("lpassword");
		UserDaoImpl checkLogin= new UserDaoImpl();
		User login= checkLogin.validate(password, userEmail);
		if(userEmail.length()==0||password.length()==0)
		{
			request.setAttribute("messages", "Please make sure to fill all the fields");
			getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}
		
		if(login!=null)
		{
			login.setPassword("");
			request.getSession(true).setAttribute("user", login);
			
			doGet(request, response);
			
		}
		else
		{
	
			request.setAttribute("messages", "There was a problem , please check that your email and password are corrects");
			getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}
		

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		User user= (User) session.getAttribute("user");
		if(user!=null)
		{

		TransactionImpl service = new TransactionImpl();
		Peanut peanut = service.findPeanut(user.getId());
		session.setAttribute("peanut", peanut);
		
	    response.sendRedirect(request.getContextPath() + "/Profile");
			
		}
		else
		{
			getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}
		
		
	}
	
	
	
}
