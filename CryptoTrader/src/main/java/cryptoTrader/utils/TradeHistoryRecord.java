/*This use Singleton*/
package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.List;

import cryptoTrader.UIObserver.UIState;
import cryptoTrader.analysis.TradeResult;

/**
 * @author Daiying Erica Zhu, Chun Yang
 * Description: We use Observer Design Patter
 *              This is the subject that the observers observe
 */

public class TradeHistoryRecord extends UIState {	
	private static TradeHistoryRecord recordTable = null;
	private List<TradeResult> record;
	
	
	/**
	 *This is the Constructor that create a new TradeHistoryRecord object and initialize an array to store all record
	 */
	public TradeHistoryRecord(){
		record = new ArrayList<TradeResult>();
		
	}
	
	/**
	 *This private helper method that update trade action history state by adding new records to past records
	 *@param newRecords is a list of new trade result generated by last perform trade action
	 */
	private void updateRecord(List<TradeResult> newRecords) {
		
		if (recordTable == null) {
			recordTable = new TradeHistoryRecord();
		}
		newRecords.addAll(recordTable.record);
		recordTable.record=newRecords;
	}
	
	/**
	 *This is getter method that return the list of all trade result
	 *@return the list of all trade result
	 */
	public static List<TradeResult> getRecord() {
		return recordTable.record;	
	}
	
	/**
	 *This is getter method that return the TradeHistoryRecord object
	 *@return the TradeHistoryRecord object
	 */
	public static TradeHistoryRecord getTable() {
		
		return recordTable;
	}
	
	/**
	 *This update the past record and notify all observer
	 *@param newRecords is the list of newly generated trade result
	 */
	
	public void update(List<TradeResult> newRecords) {
		// update trade action history state
		updateRecord(newRecords);
		notifyObservers();
	}
}
