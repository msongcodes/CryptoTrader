package cryptoTrader.strategy;

/**
 * @author Chun Yang
 * Description: This is class to hold the information of coin
 * */
public class CoinInfo {
	/**
	 *name is the coin name
	 *price is the coin price
	 */
	private String name;
	private double price;
	
	/**
	 * Constructor that create new CoinInfo object.
	 * @param name is the coin name
	 * @param price is the coin price
	 */
	public CoinInfo(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	/**
	 * Set the name of coin
	 * @param name is the coin name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the price of coin
	 * @param price is the coin price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter method that get the name of coin
	 * @return the name of coin
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter method that get the price of coin
	 * @return the price of coin
	 */
	public double getPrice() {
		return this.price;
	}
}
