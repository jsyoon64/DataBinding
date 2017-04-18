package com.jsyoon.bindexam1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsyoon.bindexam1.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding activity2Binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        SecAPresenter presenter = new SecAPresenter(this);
        activity2Binding.setPresenter(presenter);
    }
}
