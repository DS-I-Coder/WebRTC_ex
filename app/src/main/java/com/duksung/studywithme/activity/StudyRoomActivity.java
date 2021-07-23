package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.duksung.studywithme.R;

public class StudyRoomActivity extends AppCompatActivity {
    TextView tv_join_chatting_room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        //원래 있던 레이아웃인 activity_study_room은 오류가 나서 activity_connect로 해줬음...

        
        //채팅방으로 넘어감
        tv_join_chatting_room =findViewById(R.id.tv_join_chatting_room);
        tv_join_chatting_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnterChattingRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}