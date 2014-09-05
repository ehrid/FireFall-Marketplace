package org.firefallmarketplace.database.handlers;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.database.objects.PriceObject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author horodysk
 */
public class PriceDataBaseHandler {
    /***/
    public static final String TABLE_NAME = "prices";

    private static final String KEY_ID = "id";

    private static final String KEY_RES = "resoure";

    private static final String KEY_DATE = "date";

    private static final String KEY_PRICE = "price";

    /***/
    public String getCreateSQL() {
        return String.format(
            "CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY, %s INTEGER, %s INTEGER, %s DOUBLE)",
            TABLE_NAME, KEY_ID, KEY_RES, KEY_DATE, KEY_PRICE);
    }

    /***/
    public List<PriceObject> getForRes(int resId, SQLiteDatabase db) {
        List<PriceObject> priceList = new ArrayList<PriceObject>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_RES + " = " + resId;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows apriceListnd adding to list
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                int res = Integer.parseInt(cursor.getString(1));
                int date = Integer.parseInt(cursor.getString(2));
                double price = Double.parseDouble(cursor.getString(3));
                PriceObject item = new PriceObject(id, res, date, price);
                priceList.add(item);
            }
            while (cursor.moveToNext());
        }

        return priceList;
    }

    /***/
    public void add(PriceObject object, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(KEY_RES, object.getResourceId());
        values.put(KEY_DATE, object.getTimestamp());
        values.put(KEY_PRICE, object.getPrice());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

}
