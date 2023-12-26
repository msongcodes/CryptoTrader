package cryptoTrader.strategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cryptoTrader.analysis.TradeResult;

/**
 * @author: Chun Yang
 * Description: This is Strategy method design pattern for defining Strategies
 *              Strategy C: If the price of BIC is less than or equal to $45,000 and price of ADA is more than $2, 
 *                          then sell ADA coins worth of $1000 and buy BIC worth of $100,000
 *                          Otherwise buy ADA coins worth of $500 and sell BIC worth of $50,000
 * */
public class StrategyC extends Strategy {
	private List<String> relatedCoins;
	public StrategyC(){
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
		double bitcoinPrice = 0;
		double adaPrice = 0;
		for(CoinInfo coin : coinList) {
			// we get the two coin prices
			if(coin.getName().equals("bitcoin")) {
				bitcoinPrice = coin.getPrice();
			}
			if(coin.getName().equals("cardano")) {
				adaPrice = coin.getPrice();
			}
			
		}
		// if either one of price is 0, that means we didn't get both price for coin
		if(bitcoinPrice != 0 && adaPrice != 0) {
			status = true;
			if(bitcoinPrice <= 45000 && adaPrice > 2) {
				// sell ada coin
				double amount = 1000 / adaPrice;
				result.add(new TradeResult(brokerName, "Strategy-C", "ADA", "Sell", amount, adaPrice, strDate));
				// buy BIC
				amount = 100000 / bitcoinPrice;
				result.add(new TradeResult(brokerName, "Strategy-C", "Bitcoin", "Buy", amount, bitcoinPrice, strDate));
			}else {
				// buy ada coin
				double amount = 500 / adaPrice;
				result.add(new TradeResult(brokerName, "Strategy-C", "ADA", "Buy", amount, adaPrice, strDate));
				// sell BIC
				amount = 50000 / bitcoinPrice;
				result.add(new TradeResult(brokerName, "Strategy-C", "Bitcoin", "Sell", amount, bitcoinPrice, strDate));
			}
		}
		
		// if trade transaction fails, we generate failed trade result
		if(status == false) {
			// set price and quantity are 0 means it is Null
			result.add(new TradeResult(brokerName, "Strategy-C", "Null", "Fail", 0, 0, strDate));	
		}
		return result;
	}
}
