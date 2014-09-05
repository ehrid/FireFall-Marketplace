package org.firefallmarketplace.database.handlers;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.database.objects.ResourceObject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author horodysk
 */
public class ResourceDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "resources";

    /***/
    public List<ResourceObject> getForCategory(int catId, SQLiteDatabase db) {
        List<ResourceObject> resourceList = new ArrayList<ResourceObject>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE category = " + catId;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                int cat = Integer.parseInt(cursor.getString(1));
                String image = cursor.getString(2);
                String name = cursor.getString(3);
                String type = cursor.getString(4);
                ResourceObject item = new ResourceObject(id, image, cat, name, type);
                resourceList.add(item);
            }
            while (cursor.moveToNext());
        }

        return resourceList;
    }
}
