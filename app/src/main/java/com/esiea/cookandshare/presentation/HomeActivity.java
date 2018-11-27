package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.data.Ingredient;
import com.esiea.cookandshare.data.RestAPI;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        buttonSignIn = (Button) findViewById(R.id.button_sign_in);
        buttonSignUp = (Button) findViewById(R.id.button_sign_in);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonSignUp.setOnClickListener(v -> model.onClickedSignUpBtn());
    }
}
