package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

public class RegisterServlet extends HttpServlet {
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String name=request.getParameter("rname");
		String email= request.getParameter("remail");
		String password= request.getParameter("rpassword");
		
		User newUser= new User();
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setPassword(password);
		
		UserDaoImpl registerUser= new UserDaoImpl();
		
		String answer= registerUser.insert(newUser);
		if(answer.equals("Success"))
		{
			newUser.setId(registerUser.findId(email));
			TransactionImpl tran= new TransactionImpl();
			tran.insertPeanut(newUser.getId());
			
			//request.getSession(true).setAttribute("user", newUser);
			session.setAttribute("user", newUser);
			
			TransactionImpl service = new TransactionImpl();
			Peanut peanut = service.findPeanut(newUser.getId());
			session.setAttribute("peanut", peanut);
			
			AppType apps = new AppType();
			apps.setAll(service.findAllApp());
			apps.setJoined(service.findUserApps(newUser.getId()));
			List<App> newForMe = service.remove(apps.getAll(), apps.getJoined());
			
			apps.setNewForMe(newForMe);
			apps.setType("All");
			session.setAttribute("apps", apps);
			
			List<Record> records = service.findAllRecord(newUser.getId());
			session.setAttribute("records", records);
			request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", answer);
			 request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
