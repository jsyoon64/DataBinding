package com.jsyoon.twowaybinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import com.jsyoon.twowaybinding.utils.ObservableString;

import java.util.Objects;
import java.util.Observable;

/**
 * Created by ShinwooEND on 2017-04-18.
 */

public class Echo {
    public ObservableString text = new ObservableString();

    public Echo() { }

    public void buttonClick() {
    }
}
