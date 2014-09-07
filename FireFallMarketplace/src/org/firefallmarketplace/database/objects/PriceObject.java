package org.firefallmarketplace.database.objects;

import java.io.Serializable;
import java.util.Date;

public class PriceObject implements Serializable {
    /***/
    private static final long serialVersionUID = 7525837736594177392L;

    private int id;

    private int resourceId;

    private long timestamp;

    private int price;

    public PriceObject(int resourceId, long timestamp, int price) {
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.price = price;
    }

    public PriceObject(int id, int resourceId, long timestamp, int price) {
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

    @SuppressWarnings("deprecation")
    public double getDate() {
        Date time = new Date(timestamp);
        int i = time.getHours() * 60 + time.getMinutes();
        return i == 0 ? timestamp : i;
    }

    public int getPrice() {
        return price;
    }
    // TODO get date

}
