package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.App;
import model.AppType;
import model.Peanut;
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
		Map<String, String> map = new HashMap<>();
		map.put("userId", String.valueOf(user.getId()));
		map.put("userName", user.getName());
		map.put("userEmail", user.getEmail());
		if (temp == null) {
			temp = apps.getApp(appId);
			apps.getJoined().add(temp);
			apps.getAll().remove(temp);
			apps.getNewForMe().remove(temp);
			Peanut peanut = (Peanut) session.getAttribute("peanut");
			peanut.setPoints(peanut.getPoints() - temp.getPoints());
			tran.updatePeanut(peanut);
			Peanut ownerP = tran.findPeanut(temp.getOwnerId());
			ownerP.setPoints(ownerP.getPoints() + temp.getPoints());
			tran.updatePeanut(ownerP);
			tran.insertUserApp(new UserApp(user.getId(), appId, new Date()));
		} 
		response.sendRedirect("http://localhost:8080/HelloServlet/");

		//response.sendRedirect("localhost:8080/" + temp.getName() + "/enter?user=" + map);
		
	}
	
}
