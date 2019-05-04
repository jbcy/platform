package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.App;
import model.Peanut;
import model.User;
import service.TransactionImpl;

@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class UploadAppHandler extends HttpServlet {

	private static final String SAVE_DIR = "uploadedFiles";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int points = Integer.parseInt(request.getParameter("points"));
		if (new TransactionImpl().findAppByName(name) == null) {
			// Get absolute path of this running web application
			String appPath = request.getServletContext().getRealPath("");
			//String appPath = "/Users/Batawar/Desktop/Github/test";
			// Create path to the directory to save uploaded file
			String savePath = appPath + File.separator + SAVE_DIR;
			// Create the save directory if it does not exist
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			for (Part part : request.getParts()) {
				  String fileName = extractFileName(part);
				  if (!fileName.equals("")) {
					  part.write(savePath + File.separator + fileName);
				  }
				 
			}
			TransactionImpl tran = new TransactionImpl();
			tran.insertApp(new App(((User) session.getAttribute("user")).getId(), name, description, 0, points));
			
			session.removeAttribute("status");
			getServletContext().getRequestDispatcher("/jsp/status.jsp").include(request, response);
		} else {
			session.setAttribute("status", "please change your app name");
			getServletContext().getRequestDispatcher("/jsp/uploadAppPage.jsp").include(request, response);
		}
		
		
		
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition"); 
		String[] items = contentDisp.split(";");
		for (String s : items) {
		       if (s.trim().startsWith("filename")) {
		         return s.substring(s.indexOf("=") + 2, s.length()-1);
		       } 
		}
		return ""; 
	}
}
