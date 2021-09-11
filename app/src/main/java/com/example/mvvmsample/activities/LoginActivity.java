package com.example.mvvmsample.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.View;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.mvvmsample.R;
import com.example.mvvmsample.viewmodel.AppViewModel;
import com.example.mvvmsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModel updates the Model when changes are observed in the View
        // and model updates the view using the ViewModel
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setAppViewModel(new AppViewModel());
        activityMainBinding.executePendingBindings();

    }

    // any change in toastMessage invokes this method
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
    }
}
