package cryptoTrader.strategy;
/**
 * @author: Chun Yang
 * Description: This is Strategy C creator
 * */
public class StrategyCreatorC extends StrategyCreator {
	
	/**
	 * This method will create a Strategy C object
	 * @return Strategy C object
	 */
	@Override
	public Strategy strategyFactory() {
		return new StrategyC();
	}
}
