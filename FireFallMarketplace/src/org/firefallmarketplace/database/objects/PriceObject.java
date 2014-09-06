package org.firefallmarketplace.database.objects;

import java.io.Serializable;

public class PriceObject implements Serializable {
    /***/
    private static final long serialVersionUID = 7525837736594177392L;

    private int id;

    private int resourceId;

    private long timestamp;

    private double price;

    public PriceObject(int resourceId, long timestamp, double price) {
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.price = price;
    }

    public PriceObject(int id, int resourceId, long timestamp, double price) {
        this.id = id;
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getPrice() {
        return price;
    }

}
