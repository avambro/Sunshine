package com.example.cavalos.sunshine.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by cavalos on 11/14/14.
 */
public class LoginActivity extends Activity {

    private EditText userNameEditText;
    private EditText passwordEditText;

    private Button loginButton;

    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        setContentView(R.layout.login_layout);


        userNameEditText = (EditText) findViewById(R.id.editTextUsername);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        loginButton      =  (Button) findViewById(R.id.buttonLogin);



        loginButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(userNameEditText.getText().toString().equals("admin") &&
                        passwordEditText.getText().toString().equals("admin")) {
                    finish();
                } else {
                    Log.d("Login", "Wrong username/password");
                }
            }
        });



    }
}
