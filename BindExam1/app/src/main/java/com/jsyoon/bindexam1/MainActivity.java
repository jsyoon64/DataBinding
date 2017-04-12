package com.jsyoon.bindexam1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsyoon.bindexam1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //binding.hello.setText("Hello World");
        User user = new User("Test", "User");

        //
        // <data>
        // <variable name="user" type="com.jsyoon.bindexam1.User"/>
        //</data>
        // 위의 선언에 대한 generated setter class 이다
        binding.setUser(user);
        User user1 = new User("Test1", "User1");
        binding.setUser(user1);

        MyHandlers handlers = new MyHandlers();
        binding.setHandlers(handlers);

        Presenter presenter = new Presenter();
        binding.setPresenter(presenter);
    }
}
