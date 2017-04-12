package com.jsyoon.bindexam1;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ShinwooEND on 2017-04-11.
 */

public class MyHandlers {
    private Context context;

    public MyHandlers(Context context) {
        this.context = context;
    }

    public void onClickFriend(View view) {
        Toast.makeText(context, "Method 참조 이벤트 바인딩", Toast.LENGTH_SHORT).show();
    }
}
