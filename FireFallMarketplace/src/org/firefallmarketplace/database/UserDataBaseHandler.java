package org.firefallmarketplace.database;

import java.util.List;

import org.firefallmarketplace.database.handlers.PriceDataBaseHandler;
import org.firefallmarketplace.database.objects.PriceObject;

import android.database.sqlite.SQLiteDatabase;

/**
 * @author horodysk
 */
public class UserDataBaseHandler {

    private PriceDataBaseHandler priceHandler = new PriceDataBaseHandler();

    /***/
    public void createUserDatabase(SQLiteDatabase db) {
        db.execSQL(priceHandler.getCreateSQL());
    }

    /***/
    public List<PriceObject> getPricesForResource(int resId, SQLiteDatabase db) {
        return priceHandler.getForRes(resId, db);
    }

    /***/
    public void addPrice(PriceObject object, SQLiteDatabase db) {
        priceHandler.add(object, db);
    }

}
