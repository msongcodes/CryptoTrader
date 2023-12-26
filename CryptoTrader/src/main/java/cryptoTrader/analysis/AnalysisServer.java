package cryptoTrader.analysis;

import java.util.ArrayList;
import java.util.List;

import cryptoTrader.gui.ErrorMessageUI;
import cryptoTrader.manager.TradeBroker;
import cryptoTrader.strategy.CoinInfo;


/**
 * @author Daiying Erica Zhu, Chun Yang
 *Description: The analysis server perform trade for all brokers
 *and store the tradeResult of the trades. It also stores the name
 *of all broker whose trade failed.
 */

public class AnalysisServer {
	
	/** 
	 * tradeRecord: stored trade result
	 * ErrorInfo: stored errors when trade performs
	 */
	private List<TradeResult> tradeRecord;
	private List<String> ErrorInfo;
	
	/**
	 * Construct a new analysis server.Initialize new ArrayList for tradeRecord and an
	 * ArrayList for ErrorInfo
	 */
	public AnalysisServer() {
		tradeRecord = new ArrayList<TradeResult>();
		ErrorInfo = new ArrayList<String>();
	}
	
	
	
	/**
	 * Perform trade for each broker
	 * @param brokers a list of all tradeBrokers
	 */
	public void performTrade(List<TradeBroker> brokers) {
		int numBroker = brokers.size();
		for(int i = 0; i < numBroker; i++) {
			TradeBroker broker = brokers.get(i);
			// perform strategy and get list of result
			List<TradeResult> result = broker.performStrategy();
			for(TradeResult res : result) {
				// add result to result record
				tradeRecord.add(res);
				// if the trade is not successful, we also need to add it to error list
				if(res.TradeSucceeded()==false) {
					ErrorInfo.add(res.getBrokerName());
				}
			}					
		}
	}
	

	/**
	 * Display all error in Error UI
	 */
	public void displayErrorInfo() {
		if (ErrorInfo.isEmpty()){
			return;
		}
		else {
			new ErrorMessageUI(ErrorInfo);
		}
	}
	
	/**
	 * @return a list of all trade result
	 */
	public List<TradeResult> getResult(){
		return tradeRecord;
	}

}
