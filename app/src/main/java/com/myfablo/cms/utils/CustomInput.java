package com.myfablo.cms.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;

public class CustomInput {

    public static void enforceFormat(EditText editText) {
        // Set input filters
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.AllCaps(); // Force all caps
        editText.setFilters(filters);

        // Add TextWatcher
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Remove TextWatcher to prevent infinite loop
                editText.removeTextChangedListener(this);

                // Implement the logic to force format here
                // Example: Check the length of the input and modify it to match the pattern

                // Re-attach the TextWatcher
                editText.addTextChangedListener(this);
            }
        });
    }
}