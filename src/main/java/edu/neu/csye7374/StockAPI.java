package edu.neu.csye7374;

public abstract class StockAPI {
    private String id;
    protected double price;
    private String description;


    public StockAPI(String id,double price,  String description){
        this.id=id;
        this.price=price;
        this.description=description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockAPI{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract int getMetric();
}
