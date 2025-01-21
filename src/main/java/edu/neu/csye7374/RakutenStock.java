package edu.neu.csye7374;

import java.util.LinkedList;
import java.util.Queue;

public class RakutenStock extends StockAPI implements Tradable {
    private Queue<Double> bids = new LinkedList<>();
    private static final int MAX_BIDS = 6;

    public RakutenStock(String id, double price, String description) {
        super(id, price, description);
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidPrice = Double.parseDouble(bid);
            if (bids.size() == MAX_BIDS) {
                bids.poll();  // Remove the oldest bid if we already have 6 bids
            }
            bids.add(bidPrice);
            setPrice(bidPrice);  // Update the stock's current price
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid input. Please provide a valid number.");
        }
    }

    @Override
    public int getMetric() {
        if (bids.size() < 2) return 0;  // Can't calculate performance with fewer than 2 bids

        double totalBidChange = 0;
        double previousBid = -1;

        // Calculate the total change in bid prices
        for (double bid : bids) {
            if (previousBid != -1) {
                totalBidChange += (bid - previousBid);
            }
            previousBid = bid;
        }

        // The metric could be the average change
        return (int) (totalBidChange / (bids.size() - 1));
    }
}
