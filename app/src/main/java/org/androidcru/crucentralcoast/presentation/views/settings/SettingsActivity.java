package org.androidcru.crucentralcoast.presentation.views.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;

import com.google.api.client.googleapis.util.Utils;

import org.androidcru.crucentralcoast.R;

/**
 * Created by main on 5/4/2016.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String themeName = pref.getString("CruGoldTheme", "YES");
        if (themeName != null && themeName.equals("YES")) {
            setTheme(R.style.CruGoldIsBest);
        }
        else {
            System.out.println("THE THEME WAS " + themeName);
            setTheme(R.style.AppTheme);
        }
        //end
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // sets up the SettingS Activity title and view
        getSupportActionBar().setTitle("Settings");
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
    }
}