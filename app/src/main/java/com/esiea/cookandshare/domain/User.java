package com.esiea.cookandshare.domain;

import android.util.Patterns;

public class User
{
    public String uEmail;
    public String uPassword;

    public User(String uEmail, String uPassword)
    {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
    }

    public String getEmail()
    {
        if (uEmail == null)
        {
            return "";
        }
        return uEmail;
    }

    public void setEmail(String uEmail)
    {
        this.uEmail = uEmail;
    }

    public String getPassword()
    {
        if (uPassword == null)
        {
            return "";
        }
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
