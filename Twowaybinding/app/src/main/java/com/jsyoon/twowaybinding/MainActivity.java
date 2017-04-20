package com.jsyoon.twowaybinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsyoon.twowaybinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String ECHO = "echotest";
    private String mEcho;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if(savedInstanceState != null) {
            // Restore value of members from saved state
            mEcho = savedInstanceState.getString(ECHO);
        } else {
            // Probably initialize members with default values for a new instance
            mEcho = ECHO;
        }
        Echo echo = new Echo();
        echo.text.set(mEcho);

        // layout에 있는 echo 변수 set
        binding.setEcho(echo);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(ECHO, mEcho);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG, "Inside of onRestoreInstanceState");
        startTime = (Calendar) savedInstanceState.getSerializable("starttime");
    }
    */
}
