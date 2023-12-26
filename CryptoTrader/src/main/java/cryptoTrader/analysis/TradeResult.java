
package cryptoTrader.analysis;

/**
 * @author Daiying Erica Zhu, Chun Yang
 * Description: This class is the structure for Trade result
 */
public class TradeResult {

	/**
	 * name stored broker name
	 * strategyType stored strategy the broker selected
	 * coinTraded stored the coin being traded
	 * action stored trading action buy or sell or fail
	 * tradeAmount stored amount of coin being traded
	 * tradePrice stored the price of coin been traded
	 * date stored the date of trade
	 * status stored if the trade failed or succeeded
	 */
	private String name;
	private String strategyType;
	private String coinTraded;
	private String action;
	private double tradeAmount;
	private double tradePrice;
	private String date;
	private Boolean status;
	
	
	/**
	 * Constructor and create a new TradeResult object
	 *@param name is name of broker
	 *@param strategyType is strategy the broker selected
	 *@param action stored trading action buy or sell or fail
	 *@param tradeAmount stored amount of coin being traded
	 *@param tradePrice stored the price of coin been traded
	 *@param date stored the date of trade
	 */
	public TradeResult(String name, String strategyType,String coinTraded,String action, double tradeAmount, double tradePrice,String date) {
		this.name = name;
		this.strategyType = strategyType;
		this.coinTraded = coinTraded;
		this.action = action;
		this.tradeAmount = tradeAmount;
		this.tradePrice = tradePrice;
		this.date = date;
		//If action is fail means the trade failed, set status to false
		if ((action.toLowerCase()).equals("fail")) {
			status = false;
		}
		else {
			status = true;
		}
		
	}
	
	/**
	 * helper function to convert the month from digit to word
	 *@param input is the date in number format
	 *@return date in word format
	 */
	
	private String formatDate(String input) {
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String[] inputArr = input.split("-");
		String month = inputArr[1];
		int intMonth = Integer.parseInt(month);
		String strMonth = months[intMonth - 1];
		inputArr[1] = strMonth;
		return String.join("-", inputArr);
	}
	
	/**
	 * Getter method and return status of trade
	 *@return the status of the trade if it succeeded or failed
	 */
	public Boolean TradeSucceeded() {
		return status;
	}
	
	/**
	 * Getter method and return name of broker
	 *@return the name of the broker
	 */
	public String getBrokerName() {
		return name;
	}
	
	/**
	 * Getter method and return name of strategy
	 *@return the type of strategy this trade result was generated from
	 */
	public String getStrategy() {
		return strategyType;
	}
	/**
	 * Return the TradeResult in a format to be displayed to user
	 * @return the trade result as an Object[] to be rendered to user
	 */
	
	public Object[] returnResultObject() {
		Object[] output = new String[7];
		output[0] = name;
		output[1] = strategyType;
		output[2] = coinTraded;
		output[3] = action;
		output[4] = String.format("%.4f",tradeAmount);
		output[5] = String.format("%.4f",tradePrice);
		output[6] = formatDate(date);
		return output;		
		
	}
	

}
