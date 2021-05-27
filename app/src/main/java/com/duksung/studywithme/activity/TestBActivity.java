package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.model.TestModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestBActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_b);

        TextView get_name, get_age, get_address;
        Intent intent = getIntent();


        get_name=findViewById(R.id.get_name);
        get_age=findViewById(R.id.get_age);
        get_address=findViewById(R.id.get_address);

        String name= intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
        String address= intent.getStringExtra("address");

        get_name.setText(name);
        get_age.setText(age+"");
        get_address.setText(address);

    }
}