package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.UserDaoImpl;
import model.Peanut;
import model.User;
import service.TransactionImpl;
/**
 * @author Claudia Gomez
 */
public class RegisterServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * create a new user and set the peanuts  as well as a session
	 */
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
			newUser = registerUser.findByEmail(email);
			
			TransactionImpl tran= new TransactionImpl();
			tran.insertPeanut(newUser.getId());
			

			session.setAttribute("user", newUser);
			
			TransactionImpl service = new TransactionImpl();
			Peanut peanut = service.findPeanut(newUser.getId());
	
			
		  response.sendRedirect(request.getContextPath() + "/Profile");
		}
		else
		{

			PrintWriter out = response.getWriter();
		    out.println("<div class=\"w3-panel w3-pale-yellow w3-display-container w3-border\">\n" + 
		    		"			  <span onclick=\"this.parentElement.style.display='none'\"\n" + 
		    		"			  class=\"w3-button w3-large w3-display-topright\">&times;</span>\n" + 
		    		"			  <h3>Warning!</h3>\n" + 
		    		"			  <p>"+answer + "</p>\n" + 
		    		"			</div>");
			

			 request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
