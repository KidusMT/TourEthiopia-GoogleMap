package com.googleplaystore.kidusmt.tour_ethiopia;

import android.os.Bundle;
import android.preference.PreferenceActivity;


/*
 * Created by KidusMT on 5/4/2016.
 */
public class Prefs extends PreferenceActivity {
    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
//      for changing the language of the app
//    Context context;
//    public void changeLocale(){
//        Locale locale = new Locale("en_US");
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        context.getApplicationContext().getResources().updateConfiguration(config, null);
//    }
}