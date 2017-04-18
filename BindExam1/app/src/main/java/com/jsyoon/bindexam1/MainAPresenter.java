package com.jsyoon.bindexam1;

import android.content.Context;
import android.content.Intent;

/**
 * Created by ShinwooEND on 2017-04-11.
 */

public class MainAPresenter {
    private Context context;

    public MainAPresenter(Context context) {
        this.context = context;
    }

    public void onSaveClick(User user){
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }
}