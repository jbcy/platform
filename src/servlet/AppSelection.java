package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.App;
import model.AppType;
import model.Peanut;
import model.Record;
import model.User;
import model.UserApp;
import service.TransactionImpl;

public class AppSelection extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		int appId = Integer.parseInt(request.getParameter("appId"));
		User user = (User) session.getAttribute("user");
		AppType apps = (AppType) session.getAttribute("apps");
		TransactionImpl tran = new TransactionImpl();
		App temp = apps.checkJoined(appId);

		if (temp == null) {
			temp = apps.getApp(appId);
			apps.getJoined().add(temp);
			apps.getAll().remove(temp);
			apps.getNewForMe().remove(temp);
			tran.insertUserApp(new UserApp(user.getId(), appId, new Date()));
			tran.insertRecord(new Record(user.getId(), temp.getName(), "Join the app and consume " + temp.getPoints() + " points" , new Date()));
			System.out.println("Join the app and consume " + temp.getPoints() + " points" );
		} else {
			tran.insertRecord(new Record(user.getId(), temp.getName(), "Enter " + temp.getName(), new Date()));
			System.out.println("Enter " + temp.getName());
		}
		
		Peanut peanut = (Peanut) session.getAttribute("peanut");
		peanut.setPoints(peanut.getPoints() - temp.getPoints());
		tran.updatePeanut(peanut);
		if (temp.getOwnerId() != 0) {
			Peanut ownerP = tran.findPeanut(temp.getOwnerId());
			ownerP.setPoints(ownerP.getPoints() + temp.getPoints());
			tran.updatePeanut(ownerP);
		}
		//response.sendRedirect("http://localhost:8080/HelloServlet/");
		if (temp.getName().equals("ServletDBLog4jExample")) {
			response.sendRedirect("http://143.167.9.222:8080/" 
		+ URLEncoder.encode(temp.getName(), "UTF-8") 
		+ "/home.jsp");
		} else {
			response.sendRedirect("http://143.167.9.222:8080/" 
		+ URLEncoder.encode(temp.getName(), "UTF-8")  
		+ "/enter?id=" + URLEncoder.encode(String.valueOf(user.getId()), "UTF-8")  
		+ "&email=" + URLEncoder.encode(user.getEmail() + "@sheffield.ac.uk", "UTF-8") 
		+ "&name=" + URLEncoder.encode(user.getName(), "UTF-8"));
		}
		
		
	}
	
}
