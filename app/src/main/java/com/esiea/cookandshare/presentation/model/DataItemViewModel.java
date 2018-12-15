package com.esiea.cookandshare.presentation.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.esiea.cookandshare.data.Ingredient;

public class DataItemViewModel extends BaseObservable
{
    private Ingredient ingredient;

    public DataItemViewModel(Ingredient ingredient)
    {
        this.ingredient = ingredient;
    }

    public void setUp()
    {

    }

    public void tearDown()
    {

    }

    @Bindable
    public String getName()
    {
        return !TextUtils.isEmpty(ingredient.getName()) ? ingredient.getName() : "";
    }
}
