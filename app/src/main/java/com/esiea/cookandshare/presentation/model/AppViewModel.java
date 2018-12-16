package com.esiea.cookandshare.presentation.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.text.Editable;

import com.esiea.cookandshare.di.AuthenticationHandler;

public class AppViewModel extends ViewModel
{
    public MutableLiveData<Boolean> goToRegisterActivity = new MutableLiveData<>();
    public MutableLiveData<Boolean> goToLoginActivity = new MutableLiveData<>();
    public MutableLiveData<Boolean> unlockRegisterButton = new MutableLiveData<>();
    public MutableLiveData<Boolean> isAuthentificated = new MutableLiveData<>();

    public void registerUser(String username, String password, String email, Context context)
    {
        String type = "register";
        AuthenticationHandler authenticationHandler = new AuthenticationHandler(context);
        authenticationHandler.execute(type, username, email, password);
    }

    public LiveData<Boolean> onClickAuthenticate(String username, String password, Context context)
    {
        String type = "login";
        AuthenticationHandler authenticationHandler = new AuthenticationHandler(context);
        authenticationHandler.execute(type, username, password);

        return isAuthentificated;
    }

    public LiveData<Boolean> onClickedSignUpBtn()
    {
        goToRegisterActivity.setValue(true);

        return goToRegisterActivity;
    }

    public LiveData<Boolean> onClickedSignInBtn()
    {
        goToLoginActivity.setValue(true);

        return goToLoginActivity;
    }

    public void onPassTextWritten(Editable sequence, String passText)
    {
        if (sequence.toString().contentEquals(passText))
        {
            unlockRegisterButton.setValue(true);
        }
    }
}
