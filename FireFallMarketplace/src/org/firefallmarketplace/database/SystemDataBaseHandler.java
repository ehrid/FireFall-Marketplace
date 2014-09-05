package org.firefallmarketplace.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.firefallmarketplace.database.handlers.CategoryDataBaseHandler;
import org.firefallmarketplace.database.handlers.ResourceDataBaseHandler;
import org.firefallmarketplace.database.objects.CategoryObject;
import org.firefallmarketplace.database.objects.ResourceObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author horodysk
 */
public class SystemDataBaseHandler {

    private CategoryDataBaseHandler categoryHandler = new CategoryDataBaseHandler();

    private ResourceDataBaseHandler resourceHandler = new ResourceDataBaseHandler();

    /***/
    public void createSystemDatabase(SQLiteDatabase db, Context context) {
        try {
            InputStream input = context.getAssets().open("database/FireFallMarketplaceSystemData.sql");

            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String str;

            while ((str = in.readLine()) != null) {
                db.execSQL(str);
                Log.d("DATABASE ADDED", str);
            }

            in.close();
        }
        catch (IOException e) {
            Log.d("DATABASE NOT FOUND", e.getMessage());
        }
    }

    /***/
    public List<ResourceObject> getResourcesInCategory(int catId, SQLiteDatabase db) {
        return resourceHandler.getForCategory(catId, db);
    }

    /***/
    public List<CategoryObject> getCategories(SQLiteDatabase db) {
        return categoryHandler.getAll(db);
    }

}
