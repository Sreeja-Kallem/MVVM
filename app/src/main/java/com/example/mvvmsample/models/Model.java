package com.example.mvvmsample.models;

import androidx.annotation.Nullable;

//Model class with getters and setters for Email and password/secret key

public class Model {

    @Nullable
    String email, secretKey;

    public Model(String email, String secretKey) {
        this.email = email;
        this.secretKey = secretKey;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(@Nullable String secretKey) {
        this.secretKey = secretKey;
    }

}
