package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.duksung.studywithme.R;

// 처음 실행시 보여지는 액티비티
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}