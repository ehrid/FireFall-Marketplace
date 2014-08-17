package org.firefallmarketplace.splashscreen;

import org.firefallmarketplace.R;
import org.firefallmarketplace.activities.MainActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author horodysk
 */
public class LogoEhrid extends SplashscreanActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLogo(R.drawable.logo_ehrid);
    }

    @Override
    protected void startActivity() {
        Intent intent = new Intent(LogoEhrid.this, MainActivity.class);
        startActivity(intent);
    }

}
