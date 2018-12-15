package com.esiea.cookandshare.domain;

import android.util.Patterns;

public class User
{
    public String uUsername;
    public String uEmail;
    public String uPassword;

    public User(String username, String email, String password)
    {
        this.uUsername = username;
        this.uEmail = email;
        this.uPassword = password;
    }

    public String getUsername()
    {
        return uUsername;
    }

    public void setUsername(String uUsername)
    {
        this.uUsername = uUsername;
    }

    public String getEmail()
    {
        return uEmail;
    }

    public void setEmail(String uEmail)
    {
        this.uEmail = uEmail;
    }

    public String getPassword()
    {
        return uPassword;
    }

    public void setPassword(String uPassword)
    {
        this.uPassword = uPassword;
    }

    public boolean isEmailValid()
    {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    public boolean isPasswordLengthValid()
    {
        return getPassword().length() > 5;
    }
}
