package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

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

public class AppChecker extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		
		User user = (User) session.getAttribute("user");
		TransactionImpl tran = new TransactionImpl();
		String action = request.getParameter("action");
		if (action != null) {
			if (!action.equals("delete")) {
				int appId = Integer.parseInt(request.getParameter("appId"));
				App temp = tran.findAppById(appId);
				
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
			} else {
				
				String[] deleteApps = request.getParameterValues("deleteApps");
				for (String da : deleteApps) {
					if (request.getParameter("deleteBtn") != null) {
						tran.deleteApp(Integer.parseInt(da));
					} else {
						tran.updateAppStatus(Integer.parseInt(da));
					}
					
				}
				getServletContext().getRequestDispatcher("/jsp/admin.jsp").include(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/jsp/admin.jsp").include(request, response);
		}
		
		
		
		
		
	}
}
