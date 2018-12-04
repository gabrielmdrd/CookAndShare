package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.esiea.cookandshare.R;

public class HomeActivity extends AppCompatActivity
{
    private Button buttonSignIn;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);
        model.goToRegisterActivity.observe(this, goTo -> {
            if (goTo)
            {
                startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
            }
        });
        model.goToLoginActivity.observe(this, goTo -> {
            if (goTo)
            {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        buttonSignIn = (Button) findViewById(R.id.button_home_signIn);
        buttonSignUp = (Button) findViewById(R.id.button_home_signUp);

        buttonSignIn.setOnClickListener(v -> model.onClickedSignInBtn());
        buttonSignUp.setOnClickListener(v -> model.onClickedSignUpBtn());
    }
}
