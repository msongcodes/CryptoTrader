package cryptoTrader.abs;

import java.io.IOException;

/**
 * @author: Chun Yang
 * Proxy Design Pattern for login
 * This is Subject class - parent class
 * */
public abstract class LoginInterface {
	/**
	 * @param name username
	 * @param password user password
	 * @throws IOException
	 */
	public abstract boolean Validate(String name, String password) throws IOException;
}
