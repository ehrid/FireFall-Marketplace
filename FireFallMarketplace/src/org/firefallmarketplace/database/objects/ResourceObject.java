package org.firefallmarketplace.database.objects;

import java.io.Serializable;

public class ResourceObject implements Serializable {
    /***/
    private static final long serialVersionUID = -1173366797654946424L;

    private int id;

    private String imageResource;

    private int category;

    private String resourceName;

    private RarityType rarityType;

    public ResourceObject(int id, String imageResource, int category, String resourceName, String rarityType) {
        this.id = id;
        this.imageResource = imageResource;
        this.category = category;
        this.resourceName = resourceName;
        this.rarityType = RarityType.getByName(rarityType);
    }

    public int getId() {
        return id;
    }

    public String getImageResource() {
        return imageResource;
    }

    public int getCategory() {
        return category;
    }

    public String getResourceName() {
        return resourceName;
    }

    public RarityType getRarityType() {
        return rarityType;
    }

    public int getBackground() {
        return rarityType.getBackground();
    }

}
