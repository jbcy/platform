package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.UserDaoImpl;
import model.User;


public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session= request.getSession();
		String old = request.getParameter("password");
		String newPass = request.getParameter("newPassword");
		String repeat = request.getParameter("rpassword");
		User user= (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		if(user!=null)
		{
			
			if(old.length()==0||newPass.length()==0 || repeat.length()==0)
			{
				
				request.setAttribute("messages", "Please make sure to fill all the fields");
			

			 request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);	
			}
			 if(!newPass.equals(repeat))
			{
			
			  
				
			    request.setAttribute("messages", "The new password and the repeat password should be the same");
				 request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);		
			}
			else
			{
				UserDaoImpl change= new UserDaoImpl();
			String answer= change.updatePassword(old, newPass, user.getId());
			if(answer.equals("success"))
			{
			
				 out.println("<div class=\"w3-panel w3-green w3-display-container w3-border\">\n" + 
				    		"			  <span onclick=\"this.parentElement.style.display='none'\"\n" + 
				    		"			  class=\"w3-button w3-large w3-display-topright\">&times;</span>\n" + 
				    		"			  <h3>Password changed succesfully!</h3>\n" + 
				    		"			</div>");
				getServletContext().getRequestDispatcher("/jsp/home.jsp").include(request, response);
			}
			else
			{
			
				request.setAttribute("messages", answer);
				getServletContext().getRequestDispatcher("/jsp/home.jsp").include(request, response);
			}
			}
			
		}
		else
		{
			
			getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}
	}

}
