package org.firefallmarketplace.splashscreen;

import org.firefallmarketplace.R;
import org.firefallmarketplace.activities.CategoryListActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author horodysk
 */
public class LogoFireFall extends SplashscreanActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLogo(R.drawable.logo_firefall);
    }

    @Override
    protected void startActivity() {
        Intent intent = new Intent(LogoFireFall.this, CategoryListActivity.class);
        startActivity(intent);
    }

}
