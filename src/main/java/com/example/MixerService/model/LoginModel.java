package com.example.MixerService.model;

public class LoginModel {

    private String userNameOrEmailId,password;

    public LoginModel(){}

    public LoginModel(String userNameOrEmailId, String password)
    {
        this.userNameOrEmailId=userNameOrEmailId;
        this.password=Integer.toString(password.hashCode());
    }

    public String getUserNameOrEmailId()
    {
        return this.userNameOrEmailId;
    }

    public void setUserNameOrEmailId(String userNameOrEmailId)
    {
        this.userNameOrEmailId=userNameOrEmailId;
    }

    public 	String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password=Integer.toString(password.hashCode());
    }
}
