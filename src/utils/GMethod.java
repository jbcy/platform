package utils;

import java.util.UUID;

/**
 * For General method
 * @author Jingbo Lin
 *
 */
public class GMethod {
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
}
