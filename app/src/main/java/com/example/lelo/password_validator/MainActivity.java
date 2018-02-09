package com.example.lelo.password_validator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validateListener(View view) {
        TextView textView_feedback = findViewById(R.id.textView_feedback);
        EditText editText_password = findViewById(R.id.editText_password);
        validator = new Validator(editText_password.getText().toString());

        textView_feedback.setText(validator.getStrength());

        if (validator.isAcceptable()) {
            view.setBackgroundColor(Color.parseColor("#40CF1A"));
        } else {
            view.setBackgroundColor(Color.parseColor("#DD1E42"));
        }
    }


}
