package com.jsyoon.bindexam1;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.jsyoon.bindexam1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    RecyclerView rvUserlist;
    ObservableArrayList<User> users1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        init();
        binding.setUsers(users1);
    }

    private void init() {
        users1 = new ObservableArrayList<User>();

        rvUserlist = (RecyclerView) findViewById(R.id.rvUserlists);
        rvUserlist.setLayoutManager(new LinearLayoutManager(this));

        addusers();

        UserdataAdaptor adapter = new UserdataAdaptor(users1);
        rvUserlist.setAdapter(adapter);
    }

    private void addusers()
    {
        for (int i=0;i<20;i++) {
            User user = new User("Test"+String.valueOf(i), "User"+String.valueOf(i));
            users1.add(user);
        }
    }

}
