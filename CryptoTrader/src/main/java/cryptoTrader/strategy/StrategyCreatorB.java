package cryptoTrader.strategy;
/**
 * @author: Chun Yang
 * Description: This is Strategy B creator
 * */
public class StrategyCreatorB extends StrategyCreator {
	
	@Override
	/**
	 * This method will create a Strategy B object
	 * @return Strategy B object
	 */
	public Strategy strategyFactory() {
		return new StrategyB();
	}
}
