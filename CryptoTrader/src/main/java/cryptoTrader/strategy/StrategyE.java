package cryptoTrader.strategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang
 * Description: This is Strategy method design pattern for defining Strategies
 *              Strategy E: If the price of dogecoin is less than or equal to $0.19 then buy dogecoin worth of $5,000
 *                          If the price of dogecoin is more than $0.19 then sell dogecoin worth of $4,000
 * */
public class StrategyE extends Strategy {
	private List<String> relatedCoins;
	public StrategyE(){
		this.relatedCoins = new ArrayList<String>();
		relatedCoins.add("dogecoin");
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
		for(CoinInfo coin : coinList) {
			// we get the dogecoin
			if(relatedCoins.contains(coin.getName())) {
				status = true;
				if(coin.getPrice() <= 0.19) {
					double amount = 5000 / coin.getPrice();
					result.add(new TradeResult(brokerName, "Strategy-E", "DogeCoin", "Buy", amount, coin.getPrice(), strDate));
				} else {
					double amount = 4000 / coin.getPrice();
					result.add(new TradeResult(brokerName, "Strategy-E", "DogeCoin", "Sell", amount, coin.getPrice(), strDate));
				}	
			}
		}
		// if trade transaction fails, we generate failed trade result
		if(status == false) {
			// set price and quantity are 0 means it is Null
			result.add(new TradeResult(brokerName, "Strategy-E", "Null", "Fail", 0, 0, strDate));	
		}
		return result;
	}
}
