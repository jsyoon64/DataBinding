package com.jsyoon.bindexam1;

import android.content.Context;
import android.content.Intent;

/**
 * Created by ShinwooEND on 2017-04-18.
 */

public class SecAPresenter {
    private Context context;

    public SecAPresenter(Context context) {
        this.context = context;
    }
    public void onCalendarClick(){
        Intent intent = new Intent(context, CalendarActivity.class);
        context.startActivity(intent);
    }
}