package org.firefallmarketplace.resources;

import java.io.Serializable;

public class ResourceObject implements Serializable {
    /***/
    private static final long serialVersionUID = -1173366797654946424L;

    private int imageResourceId;

    private String resourceName;

    private RarityType rarityType;

    public ResourceObject(int imageResourceId, String resourceName, RarityType rarityType) {
        this.imageResourceId = imageResourceId;
        this.resourceName = resourceName;
        this.rarityType = rarityType;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getBackground() {
        return rarityType.getBackground();
    }

}
