package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.di.App;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ((App) getApplication()).getNetComponent().injectMainActivity(this);

        AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);
        //model.getIngredientsList().observe(this, ingredients -> { });
    }
}
