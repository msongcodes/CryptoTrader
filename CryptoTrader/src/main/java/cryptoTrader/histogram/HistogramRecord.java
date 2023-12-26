package cryptoTrader.histogram;

import java.util.ArrayList;
import java.util.List;

import cryptoTrader.UIObserver.UIState;
import cryptoTrader.analysis.TradeResult;

/**
 * @author Chun Yang, Michael Song
 * Description: We use Observer Design Pattern within this class
 *              This is State of Histogram List 
 * */
public class HistogramRecord extends UIState{ 
	
	/**
	 * recordTable is the HistogramRecord that stores all trade history
	 * record is the list of all HistogramItemInfo
	 */
	private static HistogramRecord recordTable = null; //initializes local variables
	private List<HistogramItemInfo> record;
	
	
	/**
	 * Constructor that create a new HistogramRecord object
	 */
	public HistogramRecord(){
		record = new ArrayList<HistogramItemInfo>(); //initializes a record that is a list of histograms items
	}
	
	/**
	 * Updates the record of valid trades
	 * @param data is the list of all TradeResult
	 */
	private static void updateRecord(List<TradeResult> data) { //updates the record of valid trades
		
		if (recordTable == null) { //checks to see if there are no current records to add one
			recordTable = new HistogramRecord();
		}
		List<HistogramItemInfo> newRecords = updateCounter(recordTable.record, data); 
		recordTable.record = newRecords;
	}
	
	/**
	 * Getter methods
	 * @return the list of records in the table
	 */
	public static List<HistogramItemInfo> getRecord() { //returns the list of records in the table
		return recordTable.record;	
	}
	
	/**
	 * Getter methods
	 * @return the table that stored all record
	 */
	public static HistogramRecord getTable() { //returns the table
		
		return recordTable;
	}
	
	/**
	 * Update state and notify observers
	 * @param data the list of trading result that need to be added
	 */
	public void update(List<TradeResult> data) { //updates record with data
		// update trade action history state
		updateRecord(data);
		notifyObservers();
	}
	
	/**
	 * Update the counter when trade is successful
	 * @param record is the list of all past histogramItemInfo
	 * @param data is the list of newly generated tradeResult
	 * @return record is the updated HistogramRecord
	 */
	public static List<HistogramItemInfo> updateCounter(List<HistogramItemInfo> record, List<TradeResult> data) { //provides the conditions of when to uppdate
		
		for(TradeResult dataItem : data) {
			// only update when trade is successful
			if(dataItem.TradeSucceeded()) {
				boolean exist = false;
				for(HistogramItemInfo histogramItem : record) {
					if(dataItem.getBrokerName().equals(histogramItem.getTraderName())) {
						histogramItem.incrementCounter(dataItem.getStrategy());
						exist = true;
					}
				}
				if(!exist) {
					HistogramItemInfo dataToAdd = new HistogramItemInfo(dataItem.getBrokerName());
					dataToAdd.incrementCounter(dataItem.getStrategy());
					record.add(dataToAdd);
				}
			}		
		}
		return record;
	}
}
