package cryptoTrader.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cryptoTrader.analysis.AnalysisServer;
import cryptoTrader.analysis.TradeResult;
import cryptoTrader.histogram.HistogramRecord;
import cryptoTrader.manager.BrokerManager;
import cryptoTrader.utils.DataVisualizationCreator;
import cryptoTrader.utils.TradeHistoryRecord;

/**
 * @author Daiying Erica Zhu, Chun Yang
 * Description: Facade design pattern to perform trade by
 *              calling broker manager and analysis server methods
 *
 */
public class TradeFacade {
	
	/**
	 *brokerManager store BrokerManager
	 *server store AnalysisServer
	 */
	private BrokerManager brokerManager;
	private AnalysisServer server;
	
	/**
	 * Constructor create a new TradeFacade object.
	 * Initialize a new BrokerManager and AnalysisServer
	 */
	public TradeFacade() {
		this.brokerManager = new BrokerManager();
		this.server = new AnalysisServer();
	}
	
	/**
	 * This class defines how to perform trade,
	 * we first fetch the price and notify the price to each broker
	 * then we perform trade and get result,
	 * finally we update UI
	 */
	public void PerformTrade() {		
		brokerManager.fetchPrices();
		brokerManager.notifyPricesToAll();
		server.performTrade(brokerManager.getBrokers());
		List<TradeResult> historyActionResult = server.getResult();
		TradeHistoryRecord historyActionList = new TradeHistoryRecord();
		HistogramRecord histogram = new HistogramRecord();
		DataVisualizationCreator visualization = new DataVisualizationCreator(historyActionList, histogram);
		historyActionList.update(historyActionResult);
		histogram.update(historyActionResult);
		server.displayErrorInfo();	
	}
	/**
	 * This is Facade design to add broker to broker manager
	 * @param traderName is name of broker
	 * @param interestedCoins coins that broker selected
	 * @param strategyName is the name of strategy the broker chose
	 */
	public void addBroker(String traderName, String[] interestedCoins, String strategyName) {
		brokerManager.addBroker(traderName, interestedCoins, strategyName);
	}



}
