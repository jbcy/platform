package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AppType;

public class AppTypeHandler extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession(true);
		AppType apps = (AppType) session.getAttribute("apps");
		if (request.getParameter("all") != null) {
			apps.setType("All");
		} else if (request.getParameter("newForMe") != null) {
			apps.setType("NewForMe");
		} else if (request.getParameter("joined") != null) {
			apps.setType("Joined");
		}
		session.setAttribute("apps", apps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/home.jsp");
		dispatcher.forward(request, response);
	}
}
