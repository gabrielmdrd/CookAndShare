package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.esiea.cookandshare.R;

public class LoginActivity extends AppCompatActivity
{
    private Button buttonSignIn;
    private EditText editTextLogin;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);

        buttonSignIn = (Button)findViewById(R.id.button_login_signIn);
        editTextLogin = (EditText)findViewById(R.id.editText_login_login);
        editTextPassword = (EditText)findViewById(R.id.editText_login_password);
    }
}
