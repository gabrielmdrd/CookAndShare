package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.esiea.cookandshare.R;

public class RegisterActivity extends AppCompatActivity
{
    private Button buttonSignUp;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);

        buttonSignUp = (Button)findViewById(R.id.button_register_register);
        editTextUsername = (EditText) findViewById(R.id.editText_register_username);
        editTextEmail = (EditText)findViewById(R.id.editText_register_email);
        editTextPassword = (EditText)findViewById(R.id.editText_register_password);
        editTextConfirmPassword = (EditText)findViewById(R.id.editText_register_confirmPassword);
    }
}
