package com.jsyoon.bindexam1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsyoon.bindexam1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding을 사용 할때 아래 대신 아래아래 코드를 사용한다.
        //setContentView(R.layout.activity_main);

        // ActivityMainBinding 은 .xml file에 대한  generated class
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        User user = new User("Test", "User");

        // <variable name="user" type="com.jsyoon.bindexam1.User"/>
        // 위의 선언에 대한 generated setter class 이다
        binding.setUser(user);

        MyPresenter presenter = new MyPresenter(this);

        // setPresenter
        // <variable name="presenter" type="com.jsyoon.bindexam1.Presenter" /> 에
        // 대한 generated setter class
        binding.setPresenter(presenter);
    }
}
