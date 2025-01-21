/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye7374;

/**
 *
 * @author Kruthi Hegde
 */
import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance = null;
    private List<StockAPI> stocks = new ArrayList<>();


    private StockMarket() {}


    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }


    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }


    public void removeStock(StockAPI stock) {
        if (stocks.contains(stock)) {
            stocks.remove(stock);
            System.out.println("Removed stock: " + stock.getId());
        } else {
            System.out.println("Stock not found: " + stock.getId());
        }
    }


    public void evaluateStocks() {
        for (StockAPI stock : stocks) {
            int metric = stock.getMetric();
            if (metric > 0) {
                System.out.println(stock.getId() + " is performing well with a metric of " + metric + ". Consider buying.");
            } else if (metric < 0) {
                System.out.println(stock.getId() + " is performing poorly with a metric of " + metric + ". Consider selling.");
            } else {
                System.out.println(stock.getId() + " has a neutral performance.");
            }
        }
    }


    public void showAllStocks() {
        for (StockAPI stock : stocks) {
            System.out.println(stock);
        }
    }

    public StockAPI getStockById(String id) {
        for (StockAPI stock : stocks) {
            if (stock.getId().equalsIgnoreCase(id)) {
                return stock;
            }
        }
        System.out.println("Stock not found: " + id);
        return null;
    }
}
