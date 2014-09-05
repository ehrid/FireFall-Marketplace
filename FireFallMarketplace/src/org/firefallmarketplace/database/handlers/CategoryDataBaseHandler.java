package org.firefallmarketplace.database.handlers;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.database.objects.CategoryObject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author horodysk
 */
public class CategoryDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "categories";

    /***/
    public List<CategoryObject> getAll(SQLiteDatabase db) {
        List<CategoryObject> categoryList = new ArrayList<CategoryObject>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                CategoryObject item = new CategoryObject(id, name);
                categoryList.add(item);
            }
            while (cursor.moveToNext());
        }

        return categoryList;
    }

}
