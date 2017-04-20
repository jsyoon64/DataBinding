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

    /*
    @BindingAdapter({"app:error"})
    public static void bindValidationError(TextInputLayout textInputLayout, int errorRes) {
        if (errorRes != 0) {
            textInputLayout.setError(textInputLayout.getResources().getString(errorRes));
        } else {
            textInputLayout.setError(null);
        }
    }
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