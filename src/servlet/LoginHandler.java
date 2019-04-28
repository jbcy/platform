package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.App;
import model.AppType;
import model.Peanut;
import model.Record;
import service.TransactionImpl;

public class LoginHandler extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession(true);
		String userEmail = request.getParameter("lemail");
		String password = request.getParameter("lpassword");
		
		
		model.User login = new model.User();
		
		login.setEmail(userEmail);
		login.setPassword(password);
		login.setName("test");
		login.setId(1);
		session.setAttribute("user", login);
		
		
		
		TransactionImpl service = new TransactionImpl();
		Peanut peanut = service.findPeanut(login.getId());
		session.setAttribute("peanut", peanut);
		
		AppType apps = new AppType();
		apps.setAll(service.findAllApp());
		apps.setJoined(service.findUserApps(login.getId()));
		List<App> newForMe = service.remove(apps.getAll(), apps.getJoined());
		
		apps.setNewForMe(newForMe);
		apps.setType("All");
		session.setAttribute("apps", apps);
		
		List<Record> records = service.findAllRecord(login.getId());
		session.setAttribute("records", records);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/home.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
}
