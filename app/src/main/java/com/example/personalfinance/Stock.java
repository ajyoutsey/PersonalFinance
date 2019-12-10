package com.example.personalfinance;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.data.StockData;

import java.util.List;
import java.util.Map;

public class Stock {

    private double price;

    public void stockPrice(String ticker) {
        String apiKey = "8EL4Y65ZPOUHY1ME";
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
        try {
            Daily response = stockTimeSeries.daily(ticker, OutputSize.COMPACT);
            Map<String, String> metaData = response.getMetaData();
            List<StockData> stockData = response.getStockData();
            price = stockData.get(0).getClose();
        } catch (AlphaVantageException e) {
            System.out.println("something went wrong");
        }
    }

    public double getPrice() {
        return price;
    }
}
