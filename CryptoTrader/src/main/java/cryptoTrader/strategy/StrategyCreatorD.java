package cryptoTrader.strategy;
/**
 * @author: Chun Yang
 * Description: This is Strategy D creator
 * */
public class StrategyCreatorD extends StrategyCreator {
	@Override
	/**
	 * This method will create a Strategy D object
	 * @return Strategy D object
	 */
	public Strategy strategyFactory() {
		return new StrategyD();
	}
}
