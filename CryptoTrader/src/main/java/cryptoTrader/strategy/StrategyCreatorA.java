package cryptoTrader.strategy;

/**
 * @author: Chun Yang
 * Description: This is Strategy A creator
 * */
public class StrategyCreatorA extends StrategyCreator {
	
	@Override
	/**
	 * This method will create a Strategy A object
	 * @return Strategy A object
	 */
	public Strategy strategyFactory() {
		return new StrategyA();
	}
}
