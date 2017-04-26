package com.jsyoon.settingpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;

/**
 * Created by ShinwooEND on 2017-04-25.
 */

// Implement OnSharedPreferenceChangeListener
public class SettingFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener , Preference.OnPreferenceChangeListener{

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer
        addPreferencesFromResource(R.xml.set_preference);

        // Get the preference screen, get the number of preferences and iterate through
        // all of the preferences if it is not a checkbox preference, call the setSummary method
        // passing in a preference and the value of the preference

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();

        // Go through all of the preferences, and set up their preference summary.
        for (int i = 0; i < count; i++) {
            Preference p = prefScreen.getPreference(i);
            findListPreferenceNSetSummary(sharedPreferences, p);
        }

        // Add the OnPreferenceChangeListener specifically to the EditTextPreference
        Preference preference = findPreference(getString(R.string.text_size_key));
        preference.setOnPreferenceChangeListener(this);
    }

    // Override onSharedPreferenceChanged and, if it is not a checkbox preference,
    // call setPreferenceSummary on the changed preference
    // is triggered after any value is saved to the SharedPreferences file.
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
// Figure out which preference was changed
        Preference preference = findPreference(key);
        findListPreferenceNSetSummary(sharedPreferences, preference);
    }


    // is triggered before a value is saved to the SharedPreferences file.
    // it can prevent an invalid update to a preference.
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Toast error = Toast.makeText(getContext(), "Please select a number between 1 and 45", Toast.LENGTH_SHORT);

        // if EditTextPreference key
        if(preference.getKey().equals(getString(R.string.text_size_key)))
        {
            String stringSize = (String) newValue;
            try {
                float size = Float.parseFloat(stringSize);
                // If the number is outside of the acceptable range, show an error.
                if (size > 45 || size <= 0) {
                    error.show();
                    return false;
                }
            } catch (NumberFormatException nfe) {
                // If whatever the user entered can't be parsed to a number, show an error
                error.show();
                return false;
            }
        }
        return true;
    }



    private void findListPreferenceNSetSummary(SharedPreferences sharedPreferences, Preference preference){
        if (null != preference) {
            // Updates the summary for the preference
            if ((preference instanceof ListPreference) || (preference instanceof EditTextPreference)) {
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
            }
        }
    }

    // Create a setPreferenceSummary which takes a Preference and String value as parameters.
    // This method should check if the preference is a ListPreference and, if so, find the label
    // associated with the value. You can do this by using the findIndexOfValue and getEntries methods
    // of Preference.
    /**
     * Updates the summary for the preference
     *
     * @param preference The preference to be updated
     * @param value      The value that the preference was updated to
     */
    private void setPreferenceSummary(Preference preference, String value) {
        if (preference instanceof ListPreference) {
            // For list preferences, figure out the label of the selected value
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(value);
            if (prefIndex >= 0) {
                // Set the summary to that label
                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        }
        else if (preference instanceof EditTextPreference) {
            EditTextPreference edittextPreference = (EditTextPreference) preference;
            edittextPreference.setSummary(value);
        }
    }

    // Register and unregister the OnSharedPreferenceChange listener (this class) in
    // onCreate and onDestroy respectively.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
