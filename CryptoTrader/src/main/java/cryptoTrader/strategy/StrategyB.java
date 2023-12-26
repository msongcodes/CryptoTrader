package cryptoTrader.strategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang 
 * Description: This is Strategy method design pattern for defining Strategies
 *              Strategy B: If the price of ADA is less or equal $2 and the price of 
 *                          ETH is less than $3,500 then buy ADA coins worth of $1000
 *                          Otherwise buy ETH coin worth of $2000
 * */
public class StrategyB extends Strategy {
	private List<String> relatedCoins;
	public StrategyB(){
		this.relatedCoins = new ArrayList<String>();
		relatedCoins.add("cardano");
		relatedCoins.add("ethereum");
	}
	
	/**
	 * This method will return trade result if the trade action performed or it failed, 
	 * @param brokerName is the name of broker
	 * @param coinList is the list of prices of coins that the broker requested
	 * @return list of trade result
	 */
	@Override
	public List<TradeResult> performTrade(String brokerName, List<CoinInfo> coinList) {
		boolean status = false;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date dtdate = new Date();
		String strDate = formatter.format(dtdate);
		List<TradeResult> result = new ArrayList<TradeResult>();
		double adaPrice = 0;
		double ethPrice = 0;
		for(CoinInfo coin : coinList) {
			// we get the two coin prices
			if(coin.getName().equals("cardano")) {
				adaPrice = coin.getPrice();
			}
			if(coin.getName().equals("ethereum")) {
				ethPrice = coin.getPrice();
			}
			
		}
		// if either one of price is 0, that means we didn't get both price for coin
		if(adaPrice != 0 && ethPrice != 0) {
			status = true;
			if(adaPrice <= 2 && ethPrice < 4500) {
				// buy ada coin
				double amount = 1000 / adaPrice;
				result.add(new TradeResult(brokerName, "Strategy-B", "ADA", "Buy", amount, adaPrice, strDate));
			} else {
				double amount = 2000 / ethPrice;
				result.add(new TradeResult(brokerName, "Strategy-B", "ETH", "Buy", amount, adaPrice, strDate));
			}
		}
		
		// if trade transaction fails, we generate failed trade result
		if(status == false) {
			// set price and quantity are 0 means it is Null
			result.add(new TradeResult(brokerName, "Strategy-B", "Null", "Fail", 0, 0, strDate));	
		}
		return result;
	}
}
