package edu.neu.csye7374;

import java.util.Collections;

public class Demo {
    public static void run() {
        StockMarket market = StockMarket.getInstance();

        RakutenStock rakutenStock = new RakutenStock("Rakuten", 155.0, "Rakuten Inc. Stock");
        market.addStock(rakutenStock);
        System.out.println(rakutenStock.toString());

        String[] techBids = {"152.0", "153.5", "155.0", "150.0", "149.0", "151.0"};
        for (String bid : techBids) {
            rakutenStock.setBid(bid);
            System.out.println("New price: " + rakutenStock.getPrice() + ", Performance Metric: " + rakutenStock.getMetric());
        }

        TeslaStock teslaStock = new TeslaStock("TSL", 100.0, "Tesla Inc. Stock");
        market.addStock(teslaStock);
        System.out.println(teslaStock.toString());

        String[] retailBids = {"128.0", "129.0", "131.0", "133.0", "132.0", "134.0"};
        for (String bid : retailBids) {
            teslaStock.setBid(bid);
            System.out.println("New price: " + teslaStock.getPrice() + ", Performance Metric: " + teslaStock.getMetric());
        }


        System.out.println("\nAll stocks in the market:");
        market.showAllStocks();


        System.out.println("\nEvaluating stock performance:");
        market.evaluateStocks();
    }
}

