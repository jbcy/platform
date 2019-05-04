package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
	private static String jarpath = "/usr/local/Cellar/tomcat@8/8.5.38/libexec/webapps/JBCY/uploadedFiles/"; 
	private static String destdir = "/usr/local/Cellar/tomcat@8/8.5.38/libexec/webapps/";
	
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
					  extractor(fileName);
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
	
	private void extractor(String fileName) throws IOException {
		JarFile jarfile = new JarFile(jarpath + fileName);
		for (Enumeration<JarEntry> iter = jarfile.entries(); iter.hasMoreElements();) {
			JarEntry entry = iter.nextElement(); 
			System.out.println("Processing: " + entry.getName()); 
			File outfile = new File(destdir + fileName.substring(0, fileName.length() - 4), entry.getName());
			if (! outfile.exists())
			outfile.getParentFile().mkdirs();
			if (! entry.isDirectory()) {
		      InputStream instream = jarfile.getInputStream(entry);
		      FileOutputStream outstream = new FileOutputStream(outfile);
		      while (instream.available() > 0) {
		    	  outstream.write(instream.read());
		      }
		    outstream.close();
		    instream.close();
			}  // end if
		} //endfor
		jarfile.close();
	}  
	
}
