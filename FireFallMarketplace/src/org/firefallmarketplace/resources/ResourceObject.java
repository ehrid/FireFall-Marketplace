package org.firefallmarketplace.resources;

public class ResourceObject {
    private int imageResourceId;

    private String resourceName;

    public ResourceObject(int imageResourceId, String resourceName) {
        this.imageResourceId = imageResourceId;
        this.resourceName = resourceName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

}
