package edu.neu.csye7374;

import java.util.LinkedList;
import java.util.Queue;

public class TeslaStock extends StockAPI implements Tradable {

    private Queue<Double> bids = new LinkedList<>();
    private static final int MAX_BIDS = 6;

    public TeslaStock(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidPrice = Double.parseDouble(bid);
            if (bids.size() == MAX_BIDS) {
                bids.poll();  // Remove the oldest bid if the queue is full
            }
            bids.add(bidPrice);
            setPrice(bidPrice);  // Update the stock's current price
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid input. Please provide a valid number.");
        }
    }

    @Override
    public int getMetric() {
        if (bids.size() < 2) return 0;

        double previousPrice = -1;
        double performanceSum = 0;

        for (double bid : bids) {
            if (previousPrice != -1) {
                double percentageChange = (bid - previousPrice) / previousPrice * 100;
                performanceSum += percentageChange;
            }
            previousPrice = bid;
        }
        return (int) performanceSum;
    }

}
