package cryptoTrader.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cryptoTrader.analysis.TradeResult;
import cryptoTrader.strategy.CoinInfo;
import cryptoTrader.strategy.Strategy;

/**
 * @author Daiying Erica Zhu, Chun Yang, Hanren Guo
 * Description: This is the data structure that store information
 * of broker.
 */

public class TradeBroker {
	/**
	 * name store name of broker
	 * strategyType store the strategy broker selected
	 * coinPriceList store the list of all coin prices that broker requested if it exist
	 * coinList store the list of coins that the broker selected
	 */

	private String name;
	private Strategy strategyType;
	private List<CoinInfo> coinPriceList;
	private List<String> coinList;
	
	
	/**
	 * Constructor that create a new TradeBroker object and store corresponding info
	 * @param name is the broker name
	 * @param strategy is the strategy broker selected
	 * @param requested coin is the list of coin broker requested
	 */
	public TradeBroker(String name, Strategy strategy,List<String> requestedCoin) {
		this.name = name;
		this.strategyType = strategy;
		coinList = requestedCoin;
		coinPriceList = new ArrayList<CoinInfo>();
	}	
		
	
	/**
	 * Getter method that get the name of broker
	 * @return name of broker
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method that get the list of coins broker requested
	 * @return the list of coins broker requested
	 */
	public List<String> getCoinList() {
		return coinList;
	}
	
	/**
	 * Getter method that get the list of prices for the coins broker requested
	 * @return the list of prices for the coins broker requested
	 */
	public List<CoinInfo> getPriceList() {
		return coinPriceList;
	}
	
	/**
	 * Set the coinPriceList with the list of all coin prices requested by broker
	 * @param coinPrices is the list of all coin prices requested by broker
	 */
	public void notifyPrice(List<CoinInfo> coinPrices) {
		coinPriceList = coinPrices;		
	}
	
	/**
	 * Getter method that get the Strategy the broker selected
	 * @return the type of strategy the broker selected
	 */
	public Strategy getStrategyType() {
		return strategyType;		
	}
	
	/**
	 * Evaluate the strategy broker selected and perform trade
	 * @return the the trade results after evaluating strategy and perform corresponding trade
	 */
	public List<TradeResult> performStrategy() {
		return strategyType.performTrade(name, coinPriceList);		
	}

}