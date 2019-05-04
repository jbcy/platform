package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import model.App;
import service.TransactionImpl;

/**
 * For General method
 * @author Jingbo Lin
 *
 */
public class GMethod {
	
//	private static String destdir = "/Users/Batawar/Desktop/Github/test/SecondHand";

	/**
	 * Whenever need to insert new item to database, use this function to generate id
	 * @author Jingbo Lin
	 * @return
	 */
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
	
//	public static void main(String[] args) throws IOException { 
//		JarFile jarfile = new JarFile(jarpath);
//		for (Enumeration<JarEntry> iter = jarfile.entries(); iter.hasMoreElements();) {
//			JarEntry entry = iter.nextElement(); 
//			System.out.println("Processing: " + entry.getName()); 
//			File outfile = new File(destdir, entry.getName());
//			if (! outfile.exists())
//			outfile.getParentFile().mkdirs();
//			if (! entry.isDirectory()) {
//		      InputStream instream = jarfile.getInputStream(entry);
//		      FileOutputStream outstream = new FileOutputStream(outfile);
//		    while (instream.available() > 0) {
//	          outstream.write(instream.read());
//	      }
//	      outstream.close();
//	      instream.close();
//	    }  // end if
//	} //endfor
//	  jarfile.close();
//	}  // end main

}
