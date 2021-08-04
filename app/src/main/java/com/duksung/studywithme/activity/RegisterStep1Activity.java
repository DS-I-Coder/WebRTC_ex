package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.duksung.studywithme.R;

public class RegisterStep1Activity extends AppCompatActivity {
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step1);

//        btn_register = (Button)findViewById(R.id.btn_register);
//
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), RegisterStep2Activity.class);
//                startActivity(intent);
//            }
//        });
    }
}