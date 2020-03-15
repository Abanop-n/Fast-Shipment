package com.example.android.fastshipv1;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class userdata {


    private String email , name , pass ;

    public userdata(String email ,String name ,String pass ){
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public userdata() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



}
