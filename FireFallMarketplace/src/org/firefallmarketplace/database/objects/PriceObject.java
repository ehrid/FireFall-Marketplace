package org.firefallmarketplace.database.objects;

import java.io.Serializable;

public class PriceObject implements Serializable {
    /***/
    private static final long serialVersionUID = 7525837736594177392L;

    private int id;

    private int resourceId;

    private int timestamp;

    private double price;

    public PriceObject(int resourceId, int timestamp, double price) {
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.price = price;
    }

    public PriceObject(int id, int resourceId, int timestamp, double price) {
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

    public int getTimestamp() {
        return timestamp;
    }

    public double getPrice() {
        return price;
    }

}
