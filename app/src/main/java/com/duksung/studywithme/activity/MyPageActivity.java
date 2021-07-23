package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.duksung.studywithme.R;

public class MyPageActivity extends AppCompatActivity {
    TextView tv_my_study_room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        tv_my_study_room = findViewById(R.id.tv_my_study_room);
        tv_my_study_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),StudyRoomActivity.class);
                startActivity(intent);
            }
        });

    }
}