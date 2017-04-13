package com.jsyoon.bindexam1;

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

        //binding.hello.setText("Hello World");
        User user = new User("Test", "User");

        // <variable name="user" type="com.jsyoon.bindexam1.User"/>
        // 위의 선언에 대한 generated setter class 이다
        binding.setUser(user);

        MyHandlers handlers = new MyHandlers(this);

        // setHandlers 는
        // <variable name="handlers" type="com.jsyoon.bindexam1.MyHandlers"/> 에
        // 대한 generated setter class
        binding.setHandlers(handlers);

        Presenter presenter = new Presenter(this);

        // setPresenter
        // <variable name="presenter" type="com.jsyoon.bindexam1.Presenter" /> 에
        // 대한 generated setter class
        binding.setPresenter(presenter);
    }
}
