package com.example.gobii.passwordvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordValidator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_validator);
    }

    public void validatePw(View view) {
        //this method validates the password field and then displays a message
        // (strong/ not strong) relating to the entered text.

        //get string from password field
        EditText txt = /*(EditText)*/ findViewById(R.id.inputtxt1);
        String pw = txt.getText().toString();

        //validates password string
        Validator v = new Validator();
        String msg = "Not Strong!";
        int pass = v.validate(pw);
        //determines success or fail for password validation
        if (pass == 5){
            msg = "Strong!";
        }

        //dsplays the result
        TextView disp = findViewById(R.id.outputtxt1);
        disp.setText(msg);


    }














}
