package com.example.android.fastshipv1;

/**
 * Created by h on 15/03/2020.
 */

public class RegisterResponseModel {
    String message;

    public RegisterResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
