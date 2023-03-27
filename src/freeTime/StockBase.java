package freeTime;

import java.util.ArrayList;
import java.util.List;

public class StockBase {
	public List<Stock> stockList;
	
	public StockBase() {
		stockList = new ArrayList<Stock>();
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	
	public void addStock(Stock stock) {
		this.stockList.add(stock);
	}
	public int getStockCount() {
		return stockList.size();
	}


	
	

}
