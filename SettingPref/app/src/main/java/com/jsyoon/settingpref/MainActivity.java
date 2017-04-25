package com.jsyoon.settingpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckedTextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private CheckedTextView setting1, setting2,setting3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting1 = (CheckedTextView) findViewById(R.id.setting1);
        setting2 = (CheckedTextView) findViewById(R.id.setting2);
        setting3 = (CheckedTextView) findViewById(R.id.setting3);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        setting1.setChecked(sharedPreferences.getBoolean("setting1",true));
        setting2.setChecked(sharedPreferences.getBoolean("setting2",true));
        setting3.setChecked(sharedPreferences.getBoolean("setting3",true));

        // Register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
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
        }
    }
}
