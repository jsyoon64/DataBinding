package com.jsyoon.settingpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private CheckedTextView setting1, setting2,setting3;
    private TextView textcol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting1 = (CheckedTextView) findViewById(R.id.setting1);
        setting2 = (CheckedTextView) findViewById(R.id.setting2);
        setting3 = (CheckedTextView) findViewById(R.id.setting3);
        textcol = (TextView) findViewById(R.id.textView2);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        setting1.setChecked(sharedPreferences.getBoolean("setting1",true));
        setting2.setChecked(sharedPreferences.getBoolean("setting2",true));
        setting3.setChecked(sharedPreferences.getBoolean("setting3",true));

        int ckey = getColorIntFromColorString(sharedPreferences.getString("color1", getString(R.string.color_red)));
        textcol.setTextColor(ckey);

        // Register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    // Deregister the listener
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister VisualizerActivity as an OnPreferenceChangedListener to avoid any memory leaks.
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }


    /**
     * Methods for setting up the menu
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our visualizer_menu layout to this menu */
        inflater.inflate(R.menu.setting, menu);
        /* Return true so that the visualizer_menu is displayed in the Toolbar */
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent startSettingsActivity = new Intent(this, SettingActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("setting1")) {
            setting1.setChecked(sharedPreferences.getBoolean(key,true));
        } else if (key.equals("setting2")) {
            setting2.setChecked(sharedPreferences.getBoolean(key,true));
        } else if (key.equals("setting3")) {
            setting3.setChecked(sharedPreferences.getBoolean(key,true));
        } else if (key.equals("color1")) {
            int ckey = getColorIntFromColorString(sharedPreferences.getString(key, getString(R.string.color_red)));
            textcol.setTextColor(ckey);
        }
    }

    private int getColorIntFromColorString(String newColorKey) {

        @ColorInt
        int textColor;

        if (newColorKey.equals(getString(R.string.color_red))) {
            textColor = ContextCompat.getColor(this, R.color.myRed);
        } else if (newColorKey.equals(getString(R.string.color_blue))) {
            textColor = ContextCompat.getColor(this, R.color.myBlue);
        } else {
            textColor = ContextCompat.getColor(this, R.color.myGreen);
        }

        return textColor;
    }
}
