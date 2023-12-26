package cryptoTrader.strategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang
 * Description: This is Strategy method design pattern for defining Strategies
 *              Strategy D: If the price of BIC is less than or equal to $47,000 then buy BIC coins worth of $200,000
 *                          If the price of BIC is more than $47,000, then sell BIC coins worth of $300,000
 * */
public class StrategyD extends Strategy {
	private List<String> relatedCoins;
	public StrategyD(){
		this.relatedCoins = new ArrayList<String>();
		relatedCoins.add("bitcoin");
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
			// we get the bitcoin
			if(relatedCoins.contains(coin.getName())) {
				status = true;
				if(coin.getPrice() <= 47000) {
					double amount = 200000 / coin.getPrice();
					result.add(new TradeResult(brokerName, "Strategy-D", "BitCoin", "Buy", amount, coin.getPrice(), strDate));
				}else {
					double amount = 300000 / coin.getPrice();
					result.add(new TradeResult(brokerName, "Strategy-D", "BitCoin", "Sell", amount, coin.getPrice(), strDate));
				}				
			}
		}
		// if trade transaction fails, we generate failed trade result
		if(status == false) {
			// set price and quantity are 0 means it is Null
			result.add(new TradeResult(brokerName, "Strategy-D", "Null", "Fail", 0, 0, strDate));	
		}
		return result;
	}
}