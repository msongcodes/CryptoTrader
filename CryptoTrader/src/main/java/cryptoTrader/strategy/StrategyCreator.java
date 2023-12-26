package cryptoTrader.strategy;
/**
 * @author Chun Yang
 * Description: This is abstract class for strategy creator
 * */
public abstract class StrategyCreator {
	
	/**
	 * This method will create a Strategy object
	 * @return Strategy object
	 */
	public abstract Strategy strategyFactory();
}
