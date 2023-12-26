package cryptoTrader.strategy;

import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang 
 * Description: Factory Method Design Pattern:
 *              Abstract Class for strategies - Strategy Design Pattern for strategy definition
 * */
public abstract class Strategy {
	/**
	 * Evaluate and Perform the strategy
	 * @param brokerName is the name of broker
	 * @param coinList is the list of prices of coins that the broker requested
	 * @return list of trade result
	 */
	public abstract List<TradeResult> performTrade(String brokerName, List<CoinInfo> coinList);
}
