package org.firefallmarketplace.resources;

public class ResourceObject {
    private int imageResourceId;

    private String resourceName;

    private int color;

    public ResourceObject(int imageResourceId, String resourceName, int color) {
        this.imageResourceId = imageResourceId;
        this.resourceName = resourceName;
        this.color = color;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getColor() {
        return color;
    }

}
