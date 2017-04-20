package com.jsyoon.twowaybinding.utils;

import android.databinding.BindingAdapter;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;

import com.jsyoon.twowaybinding.R;

/**
 * Created by ShinwooEND on 2017-04-19.
 */


public final class BindingAdapters {

    private BindingAdapters() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("app:text")
    public static void bindEditText(EditText view, final ObservableString observableString) {
        Pair<ObservableString, TextChangeListener> pair = (Pair) view.getTag(R.id.bound_observable);

        if (pair == null || pair.first != observableString) {
            if (pair != null) view.removeTextChangedListener(pair.second);

            //TextWatcherAdapter watcher = new TextWatcherAdapter();

            TextChangeListener watcher;
            watcher = new TextChangeListener(
                    (s, start, before, count) -> observableString.set(s.toString()));

            view.setTag(R.id.bound_observable, new Pair<>(observableString, watcher));
            view.addTextChangedListener(watcher);
        }
        String newValue = observableString.get();
        if (!view.getText().toString().equals(newValue))
            view.setText(newValue);
    }

    @BindingAdapter("app:onClick")
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(v -> runnable.run());
    }

    /*
    @BindingAdapter({"app:onClick", "app:clickable"})
    public static void setOnClick(View view, View.OnClickListener clickListener,
                                  boolean clickable) {
        view.setOnClickListener(clickListener);
        view.setClickable(clickable);
    } */
}

