package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.presentation.model.AppViewModel;

public class RegisterActivity extends AppCompatActivity
{
    private Button buttonSignUp;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    public MutableLiveData<String> passwordToWatch = new MutableLiveData<>();
    public MutableLiveData<String> confirmPasswordToWatch = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);
        model.unlockRegisterButton.observe(this, unlock -> {
            if (TextUtils.isEmpty(editTextUsername.getText()) && TextUtils.isEmpty(editTextEmail.getText()))
            {
                Toast.makeText(this, "Please fill all the fields !", Toast.LENGTH_LONG).show();
            }
            else
            {
                buttonSignUp.setEnabled(true);
            }
        });

        buttonSignUp = (Button)findViewById(R.id.button_register_register);
        editTextUsername = (EditText) findViewById(R.id.editText_register_username);
        editTextEmail = (EditText)findViewById(R.id.editText_register_email);
        editTextPassword = (EditText)findViewById(R.id.editText_register_password);
        editTextConfirmPassword = (EditText)findViewById(R.id.editText_register_confirmPassword);

        passwordToWatch.setValue(editTextPassword.getText().toString());
        confirmPasswordToWatch.setValue(editTextConfirmPassword.getText().toString());

        buttonSignUp.setOnClickListener(v -> model.registerUser(
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),
                this
        ));

        editTextConfirmPassword.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s)
            {
                model.onPassTextWritten(s, editTextPassword.getText().toString());
            }
        });
    }
}
