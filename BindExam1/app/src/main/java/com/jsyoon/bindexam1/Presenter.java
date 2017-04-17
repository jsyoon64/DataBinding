package com.jsyoon.bindexam1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ShinwooEND on 2017-04-11.
 */

public class Presenter {
    private Context context;

    public Presenter(Context context) {
        this.context = context;
    }
    public void onSaveClick(User user){
        Toast.makeText(context, "리스너 바인딩 Event"+ " "+user.getFirstName(), Toast.LENGTH_SHORT).show();
        //user.setFirstName("리스너");
    }
}