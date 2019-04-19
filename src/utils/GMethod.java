package utils;

import java.util.UUID;

/**
 * For General method
 * @author Jingbo Lin
 *
 */
public class GMethod {
	
	/**
	 * Whenever need to insert new item to database, use this function to generate id
	 * @author Jingbo Lin
	 * @return
	 */
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
	
	
}
