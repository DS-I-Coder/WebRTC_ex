package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.duksung.studywithme.R;

//채팅 방 입장 전 이름, 방 번호 입력 받아서 intent로 값 넘겨줌
public class EnterChattingRoomActivity extends AppCompatActivity {

    Button btn_enter_chat_room;
    EditText et_chat_name;
    EditText et_chat_room_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_chatting_room);

        btn_enter_chat_room=findViewById(R.id.btn_enter_chat_room);
        et_chat_name=findViewById(R.id.et_chat_name);
        et_chat_room_num=findViewById(R.id.et_chat_room_num);

        btn_enter_chat_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChattingRoomActivity.class);
                intent.putExtra("chatname",et_chat_name.getText().toString());
                intent.putExtra("roomnumber",et_chat_room_num.getText().toString());
                startActivity(intent);
            }
        });

    }
}
