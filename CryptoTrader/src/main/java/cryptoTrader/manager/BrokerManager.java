package cryptoTrader.manager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cryptoTrader.strategy.CoinInfo;
import cryptoTrader.strategy.Strategy;
import cryptoTrader.strategy.StrategyCreator;
import cryptoTrader.strategy.StrategyCreatorA;
import cryptoTrader.strategy.StrategyCreatorB;
import cryptoTrader.strategy.StrategyCreatorC;
import cryptoTrader.strategy.StrategyCreatorD;
import cryptoTrader.strategy.StrategyCreatorE;

/**
 * @author Daiying Erica Zhu, Chun Yang, Hanren Guo
 *Description: This class stores name of all brokers and all prices for all
 *the coins the brokers requested. It is responsible for fetching and notifying
 *brokers the prices of the coins they selected
 */


public class BrokerManager {
	

	/**
	 * brokers stores the list of TradeBrokers
	 * allPrices stores the prices of all coins selected by all TradeBrokers
	 */
	
	private List<TradeBroker> brokers;
	private HashMap<String, Double> allPrices;
	
	
	/**
	 * This is the constructor. It initialize brokers and allPrices
	 */
	
	public BrokerManager() {
		brokers = new ArrayList<TradeBroker>();
		allPrices = new HashMap<String, Double>();
	}

	
	/**
	 * This fetch prices using dataFetcher and store all prices and coins in a HashMap allPrices
	 */
	public void fetchPrices() {
		//Get a list of all requested coins by all brokers
		List<String> allCoins = getAllRequestedCoin();
		//Get today's date in a format accepted by CoinGeckoAPI
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String date = formatter.format(date1);
		//use AvailableCryptoList to get a list of all available crytocoins on CoinGeckoAPI
		AvailableCryptoList list = AvailableCryptoList.getInstance();
		//Create a DataFetcher object to inquire coin price
		DataFetcher fetcher = new DataFetcher();
		int numAllCoin = allCoins.size();
		//Iterate over all coins requested by brokers and get the price, and added it to allPrices
		for (int i = 0; i < numAllCoin; i++) {
			String coin  = allCoins.get(i);
			//Get the id of cryptocoin from list returned by AvailableCryptoList 
			String id =  list.getCryptoID(coin);
			
			//If coin is in the list, then get the price using DataFetcher and added it to allPrices
			if (id != null) {
				double price = fetcher.getPriceForCoin(id, date);	
				allPrices.put(coin, price);
			}
			else {
				continue;
			}				
		}		
	}
	
	
	/**
	 * This is helper method that returns a list of all coins requested by all brokers
	 * @return list of all coins requested by all brokers
	 */
	private List<String> getAllRequestedCoin(){
		List<String> allCoins = new ArrayList<String>();
		int numBroker = brokers.size();
		//Iterate over each broker
		for(int i = 0; i<numBroker;i++) {
			TradeBroker broker = brokers.get(i);
			//Get the list of coin requested by this broker
			List<String> coins = broker.getCoinList();
			int numCoin = coins.size();
			//Iterate over the coin list of this broker
			for (int j = 0; j < numCoin; j++) {
				String coin = (coins.get(j)).toLowerCase();
				//If coin not exist in the allCoin list then add it to allCoin
				if (allCoins.contains(coin)) {
					continue;
				}
				else {
					allCoins.add(coin);
				}
			}		
		}
		return allCoins;
	}

	/**
	 * This method notify the price of coins to the broker who requested it
	 */
	public void notifyPricesToAll() {
		
		int numBroker = brokers.size();
		//Iterate over all broker
		for (int i = 0; i<numBroker; i++) {
			TradeBroker broker = brokers.get(i);
			//Get the list of coin that the broker requested
			List<String> coinList = broker.getCoinList();
			List<CoinInfo> coinPriceList = new ArrayList<CoinInfo>();
			int coinNum = coinList.size();
			//Iterate over the coinList that the broker requested for and check each coin.
			for (int j = 0; j < coinNum; j++) {
				String coin = (coinList.get(j)).toLowerCase();
				//If the coin exist in the allPrices, then add it to coinPriceList
				if (allPrices.containsKey(coin)) {
					Double price = allPrices.get(coin);
					CoinInfo item = new CoinInfo(coin, price);
					coinPriceList.add(item);				
				}				
			}
			//Send the broker the coinPriceList that contains all price requested by broker
			broker.notifyPrice(coinPriceList);
		}	
	}
	
	/**
	 * This getter method get the list of brokers
	 * @return a list of brokers
	 */
	public List<TradeBroker> getBrokers(){
		return brokers;		
	}
	
	/**
	 * Description: Add broker into broker manager's broker list
	 * @param name is the broker name
	 * @param interestedCoin is the list of coin selected by broker
	 * @param strategyName is the name of Strategy selected by broker
	 * */
	public void addBroker(String name, String[] interestedCoin, String strategyName) {
		StrategyCreator creator = null;
		switch(strategyName) {
			case "Strategy-A":
				creator = new StrategyCreatorA();
				break;
			case "Strategy-B":
				creator = new StrategyCreatorB();
				break;
			case "Strategy-C":
				creator = new StrategyCreatorC();
				break;
			case "Strategy-D":
				creator = new StrategyCreatorD();
				break;
			case "Strategy-E":
				creator = new StrategyCreatorE();
				break;
		}
		Strategy strategy = creator.strategyFactory();
		TradeBroker newBroker = new TradeBroker(name, strategy, Arrays.asList(interestedCoin));
		brokers.add(newBroker);
	}
}
