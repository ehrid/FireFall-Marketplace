package org.firefallmarketplace.database;

import java.util.List;

import org.firefallmarketplace.database.handlers.CategoryDataBaseHandler;
import org.firefallmarketplace.database.handlers.ResourceDataBaseHandler;
import org.firefallmarketplace.database.objects.CategoryObject;
import org.firefallmarketplace.database.objects.PriceObject;
import org.firefallmarketplace.database.objects.ResourceObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author horodysk
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    /***/
    public static final int DATABASE_VERSION = 1;

    /***/
    public static final String DATABASE_NAME = "FireFallMartekplaceDataBase";

    private SystemDataBaseHandler systemData = new SystemDataBaseHandler();

    private UserDataBaseHandler userData = new UserDataBaseHandler();

    private Context context;

    /***/
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoryDataBaseHandler.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResourceDataBaseHandler.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        systemData.createSystemDatabase(db, context);
        userData.createUserDatabase(db);
    }

    /***/
    public void addPrice(PriceObject object) {
        userData.addPrice(object, getWritableDatabase());
    }

    /***/
    public List<PriceObject> getAllPricesForResource(int resId) {
        return userData.getAllPricesForResource(resId, getWritableDatabase());
    }

    /***/
    public List<ResourceObject> getResourcesInCategory(int catId) {
        return systemData.getResourcesInCategory(catId, getWritableDatabase());
    }

    /***/
    public List<CategoryObject> getCategories() {
        return systemData.getCategories(getWritableDatabase());
    }

}
