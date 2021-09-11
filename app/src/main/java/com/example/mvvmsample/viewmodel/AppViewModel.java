package com.example.mvvmsample.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvmsample.BR;
import com.example.mvvmsample.models.Model;

public class AppViewModel extends BaseObservable {

    //  object of Model class
    private Model model;

    private String success = "Login successfull";
    private String fail = "Login details invalid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return model.getSecretKey();
    }

    public void setUserPassword(String password) {
        model.setSecretKey(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public AppViewModel() {
        model = new Model("", "");
    }

    // Action to be performed when Login button is pressed
    public void onButtonClicked() {
        if (isLoginValid())
            setToastMessage(success);
        else
            setToastMessage(fail);
    }

    //Validates if the email and password entered are valid using pattern matcher
    public boolean isLoginValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}

