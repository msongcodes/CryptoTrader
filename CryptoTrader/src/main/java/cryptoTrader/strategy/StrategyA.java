package cryptoTrader.strategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang
 * Description: This is Strategy method design pattern for defining Strategies
 *              Strategy A: If the price of BTC is less or equal $50,000 
 *                          and the price of ADA more than $2 then buy 10 ADA coins
 *                          Otherwise sell 10 ADA coin.
 * */
public class StrategyA extends Strategy {
	private List<String> relatedCoins;
	public StrategyA(){
		this.relatedCoins = new ArrayList<String>();
		relatedCoins.add("bitcoin");
		relatedCoins.add("cardano");
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
		double bitPrice = 0;
		for(CoinInfo coin : coinList) {
			// we get the two coin prices
			if(coin.getName().equals("cardano")) {
				adaPrice = coin.getPrice();
			}
			if(coin.getName().equals("bitcoin")) {
				bitPrice = coin.getPrice();
			}
			
		}
		// if either one of price is 0, that means we didn't get both price for coin
		if(adaPrice != 0 && bitPrice != 0) {
			status = true;
			if(adaPrice > 2 && bitPrice <= 50000) {
				// buy 10 ada coin
				result.add(new TradeResult(brokerName, "Strategy-A", "ADA", "Buy", 10, adaPrice, strDate));
			} else {
				// sell 10 ada coin
				result.add(new TradeResult(brokerName, "Strategy-A", "ADA", "Sell", 10, adaPrice, strDate));
			}
		}
		
		// if trade transaction fails, we generate failed trade result
		if(status == false) {
			// set price and quantity are 0 means it is Null
			result.add(new TradeResult(brokerName, "Strategy-A", "Null", "Fail", 0, 0, strDate));	
		}
		return result;
	}
}