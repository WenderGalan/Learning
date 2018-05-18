package com.example.tdr.viewmodelapplication;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel model = ViewModelProvider.of(this).get(MyViewModel.class);
        model.getUsers().observe(this, users -> {
            //update UI
        });
    }
}
