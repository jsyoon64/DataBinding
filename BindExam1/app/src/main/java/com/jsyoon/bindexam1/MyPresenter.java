package com.jsyoon.bindexam1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ShinwooEND on 2017-04-11.
 */

public class MyPresenter {
    private Context context;

    public MyPresenter(Context context) {
        this.context = context;
    }

    public void onSaveClick(User user){
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }
}