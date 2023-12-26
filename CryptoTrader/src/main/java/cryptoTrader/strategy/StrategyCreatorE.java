package cryptoTrader.strategy;
/**
 * @author: Chun Yang
 * Description: This is Strategy E creator
 * */
public class StrategyCreatorE extends StrategyCreator {
	
	/**
	 * This method will create a Strategy E object
	 * @return Strategy E object
	 */
	@Override
	public Strategy strategyFactory() {
		return new StrategyE();
	}
}
