package com.jsyoon.twowaybinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.Objects;
import java.util.Observable;

/**
 * Created by ShinwooEND on 2017-04-18.
 */

public class Echo {
    public ObservableField<String> text = new ObservableField<>();

    public TextWatcher watcher = new TextWatcherAdapter() {
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(text.get(), s.toString())) {
                text.set(s.toString());
            }
        }
    };
}
