package com.example.mobilki5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting TextView
        TextView textFromCode = findViewById(R.id.text_from_code);
        textFromCode.setBackgroundColor(Color.parseColor("#BBBBBB"));
        textFromCode.setTextColor(Color.parseColor("#000000"));
        textFromCode.setTextSize(25);
        textFromCode.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        textFromCode.setText("Text from code");
        ConstraintLayout.LayoutParams layoutParamsForTextView = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsForTextView.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParamsForTextView.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        textFromCode.setLayoutParams(layoutParamsForTextView);


        // Working with EditText
        EditText editText1, editText2;
        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editText2.setText(editText1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        // Working with button from xml
        Button buttonFromXML = findViewById(R.id.button_from_xml);
        EditText editTextUnderXMLButton = findViewById(R.id.edit_text_under_xml_button);
        buttonFromXML.setOnClickListener(view -> {
            editTextUnderXMLButton.setText(editText1.getText().toString());
        });

        // Setting and working with button from code
        Button buttonFromCode = findViewById(R.id.button_from_code);
        buttonFromCode.setText("Enter (code)");
        ConstraintLayout.LayoutParams layoutParamsForButton = new ConstraintLayout.LayoutParams
                (400, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsForButton.topToBottom = R.id.edit_text2;
        layoutParamsForButton.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
        buttonFromCode.setLayoutParams(layoutParamsForButton);

        EditText editTextUnderCodeButton = findViewById(R.id.edit_text_under_code_button);
        ConstraintLayout.LayoutParams layoutParamsForEditText = new ConstraintLayout.LayoutParams
                (400, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsForEditText.topToBottom = R.id.button_from_code;
        layoutParamsForEditText.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
        editTextUnderCodeButton.setLayoutParams(layoutParamsForEditText);
        buttonFromCode.setOnClickListener(view -> {
            editTextUnderCodeButton.setText(editText1.getText().toString());
        });


        // Working with Toast
        Button toastButton = findViewById(R.id.toast_button);
        toastButton.setOnClickListener(view -> {
            Toast toast = Toast.makeText(this, "This is Toast!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        });


        // Working with Snackbar
        Button snackbarButton = findViewById(R.id.snackbar_button);
        snackbarButton.setOnClickListener(view -> {
            Snackbar snackbar = Snackbar.make
                    (view, "This is Snackbar!", Snackbar.LENGTH_SHORT);
            snackbar.setTextColor(0XFF81C784);
            snackbar.setBackgroundTint(0XFF555555);
            snackbar.setActionTextColor(0XFF0277BD);
            snackbar.setAction("button", viewSnackBar -> {
                Toast.makeText(this, "button is clicked", Toast.LENGTH_SHORT)
                        .show();
            });
            snackbar.show();
        });


        // Working with Checkbox
        CheckBox firstCheckBox = findViewById(R.id.first_checkbox);
        CheckBox secondCheckBox = findViewById(R.id.second_checkbox);
        Button checkBoxButton = findViewById(R.id.ckeckbox_button);
        checkBoxButton.setOnClickListener(view -> {
            Toast.makeText(this,
                    firstCheckBox.getText() + ": " + firstCheckBox.isChecked() + '\n'
                            + secondCheckBox.getText() + ": " + secondCheckBox.isChecked(),
                    Toast.LENGTH_SHORT).show();
        });


        // OnCheckedChangeListener
        firstCheckBox.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,
                                                 boolean isChecked) {
                        if (isChecked) {
                            Snackbar.make(compoundButton,
                                    firstCheckBox.getText() + ": " + firstCheckBox.isChecked(),
                                    Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
        secondCheckBox.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            Snackbar.make(compoundButton,
                                    secondCheckBox.getText() + ": " + secondCheckBox.isChecked(),
                                    Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    // Working with ToggleButton
    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            Toast.makeText(this, "Turned on",
                    Toast.LENGTH_LONG).show();
        } else {
            // действия, если выключена
            Toast.makeText(this, "Turned off",
                    Toast.LENGTH_LONG).show();
        }

    }
}