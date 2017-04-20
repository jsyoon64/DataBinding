package com.jsyoon.twowaybinding.utils;

import android.databinding.BindingConversion;
import android.view.View;

/**
 * Created by ShinwooEND on 2017-04-20.
 */

public final class BindingConversions {
    private BindingConversions() { throw new AssertionError(); }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}