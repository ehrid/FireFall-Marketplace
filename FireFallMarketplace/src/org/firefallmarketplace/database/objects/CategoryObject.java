package org.firefallmarketplace.database.objects;

import java.io.Serializable;

public class CategoryObject implements Serializable {

    /***/
    private static final long serialVersionUID = 158968095275785740L;

    private int id;

    private String name;

    public CategoryObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
