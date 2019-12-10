package com.example.personalfinance;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.data.StockData;

import java.util.List;

public class Stock {

    private double currentPrice;
    private String name;
    private int quantity;
    private double price;

    public Stock(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    public void setStockPrice(String ticker) {
        String apiKey = "8EL4Y65ZPOUHY1ME";
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
        try {
            Daily response = stockTimeSeries.daily(ticker, OutputSize.COMPACT);
            List<StockData> stockData = response.getStockData();
            currentPrice = stockData.get(0).getClose();
            System.out.println("Current price " + currentPrice);
        } catch (AlphaVantageException e) {
            System.out.println("something went wrong");
        }
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
