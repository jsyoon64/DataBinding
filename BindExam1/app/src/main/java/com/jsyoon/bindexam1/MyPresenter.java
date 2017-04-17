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
    private Navigate navi;

    public interface Navigate {
        void navigateToSecondScreen();
    }

    public MyPresenter(Context context, Navigate navi) {
        this.navi = navi;
        this.context = context;
    }

    public void onSaveClick(User user){
        navi.navigateToSecondScreen();
    }
}