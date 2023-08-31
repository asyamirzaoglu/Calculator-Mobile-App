package com.example.calculator;

import android.content.Context;

import androidx.annotation.NonNull;

public class EditTextSelectable extends androidx.appcompat.widget.AppCompatEditText {
    public EditTextSelectable(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        // imlecKonumu = selStart;
    }
}
