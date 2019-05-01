package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.App;
import model.AppType;
import model.Peanut;
import model.Record;
import model.User;
import service.TransactionImpl;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		User user= (User) session.getAttribute("user");
		if(user!=null)
		{
			
		
		TransactionImpl service = new TransactionImpl();
		Peanut peanut = service.findPeanut(user.getId());
		session.setAttribute("peanut", peanut);
		AppType apps = new AppType();
		apps.setAll(service.findAllApp());
		apps.setJoined(service.findUserApps(user.getId()));
		List<App> newForMe = service.remove(apps.getAll(), apps.getJoined());
		
		apps.setNewForMe(newForMe);
		apps.setType("All");
		session.setAttribute("apps", apps);
		
		List<Record> records = service.findAllRecord(user.getId());
		session.setAttribute("records", records);
		
		getServletContext().getRequestDispatcher("/jsp/home.jsp").include(request, response);
			
		}
		else
		{
			//redirect to login
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
