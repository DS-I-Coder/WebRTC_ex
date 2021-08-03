package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duksung.studywithme.R;

public class StudyRoomActivity extends AppCompatActivity {

    private ImageView img_chat;
    private TextView tv_stopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room);
        //원래 있던 레이아웃인 activity_study_room은 오류가 나서 activity_connect로 해줬음...

        img_chat = findViewById(R.id.img_chat);
        tv_stopWatch = findViewById(R.id.tv_stopWatch);

        // 채팅 아이콘
        img_chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void startButton(){

    }

    private void stopButton(){

    }
}