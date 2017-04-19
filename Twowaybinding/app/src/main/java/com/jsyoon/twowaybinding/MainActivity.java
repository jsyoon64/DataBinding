package com.jsyoon.twowaybinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsyoon.twowaybinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String ECHOTEST = "echotest";
    private String mEchotest;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if(savedInstanceState != null) {
            // Restore value of members from saved state
            mEchotest = savedInstanceState.getString(ECHOTEST);
        } else {
            // Probably initialize members with default values for a new instance
        }
        Echo echo = new Echo();
        echo.text.set(mEchotest);

        // layout에 있는 echo 변수 set
        binding.setEcho(echo);
        binding.edittext1.addTextChangedListener(echo.watcher);
        binding.edittext2.addTextChangedListener(echo.watcher);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(ECHOTEST, mEchotest);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
