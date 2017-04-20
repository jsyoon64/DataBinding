package com.jsyoon.twowaybinding.BindUtil;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.view.View;
import android.widget.EditText;

import com.jsyoon.twowaybinding.R;

/**
 * Created by ShinwooEND on 2017-04-20.
 */

public class MyBindingAdapters {

    private MyBindingAdapters() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    /*
     * 여기서 {"app:text"} 는 layout에 있는(activity_main.xml 의 app:text="@{echo.text}" 을 표시
     * 또한 아래 어댑터는 text가 바뀌었을 경우 자동 update 동작을 수행
     */
    @BindingAdapter({"app:text"})
    public static void bindEditText(EditText view, final ObservableString observableString) {
        if (view.getTag(R.id.binded) == null) {
            view.setTag(R.id.binded, true);
            view.addTextChangedListener(new TextWatcherAdapter() {
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    observableString.set(s.toString());
                }
            });
        }
        String newValue = observableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

    @BindingAdapter({"app:visibleOrGone"})
    public static void bindVisibleOrGone(View view, boolean b) {
        view.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"app:visible"})
    public static void bindVisible(View view, boolean b) {
        view.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter({"app:onClick"})
    public static void bindOnClick(View view, final Runnable listener) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.run();
            }
        });
    }

    @BindingConversion
    public static String convertObservableStringToString(ObservableString s) {
        return s.get();
    }
}