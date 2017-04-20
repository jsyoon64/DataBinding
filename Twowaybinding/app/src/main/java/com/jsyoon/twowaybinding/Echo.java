package com.jsyoon.twowaybinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import com.jsyoon.twowaybinding.BindUtil.ObservableString;
import com.jsyoon.twowaybinding.BindUtil.TextWatcherAdapter;

import java.util.Objects;

public class Echo {
    public ObservableString text = new ObservableString();

    public void buttonClick() {
    }
}
