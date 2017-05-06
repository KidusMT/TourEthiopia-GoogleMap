package com.googleplaystore.kidusmt.tour_ethiopia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by KidusMT on 9/2/2016.
 */
public class check extends Activity {
    public SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setting = getSharedPreferences("pref", 0);
        boolean firstRun = setting.getBoolean("firstRun", false);
        if (firstRun == false)//if the app is running for the first time
        {
            SharedPreferences.Editor editor = setting.edit();
            editor.putBoolean("firstRun", true);
            editor.commit();
            Intent i = new Intent(com.googleplaystore.kidusmt.tour_ethiopia.check.this, Splash.class);
            startActivity(i);
            finish();
        } else {
            Intent a = new Intent(com.googleplaystore.kidusmt.tour_ethiopia.check.this, MainActivity.class);
            startActivity(a);
            finish();
        }
    }
}
