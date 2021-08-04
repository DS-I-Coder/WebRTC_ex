package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.ChattingRoomModel;
import com.duksung.studywithme.model.MessageData;
import com.duksung.studywithme.model.SearchResultModel;
import com.duksung.studywithme.model.StudyRoomModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;
import com.google.gson.Gson;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StudyRoomActivity extends AppCompatActivity {



    private ImageView img_chat;
    private TextView tv_stopWatch;

    private static final String TAG = "studyroomActivity";

    Socket mSocket;
    int rId;
    String roomTitle;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room);

        img_chat = findViewById(R.id.img_chat);
        tv_stopWatch = findViewById(R.id.tv_stopWatch);

        // 채팅 아이콘
        img_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        create();

        //채팅방으로 넘어감
        TextView tv_join_chatting_room=findViewById(R.id.tv_join_chatting_room);
        tv_join_chatting_room.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        TextView tv_delete_room=findViewById(R.id.tv_delete_room);
        tv_delete_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });



    }

    //방 생성
    private void create(){
        try {
            mSocket = IO.socket(Common.BASE_SERVER_URL);
            Log.d("SOCKET", "Connection success : " + mSocket.id());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        Intent intent = getIntent();
        roomTitle = intent.getStringExtra("roomTitle");

        //소켓 연결
        mSocket.connect();

        //생성
        mSocket.on(Socket.EVENT_CONNECT, args -> {
            mSocket.emit("create", gson.toJson(new StudyRoomModel(roomTitle)));
        });




    }



    private void startButton(){

    }

    private void stopButton(){

    }



    //방 삭제
    private void delete() {
        //방 이름 넘겨서 삭제
        mSocket.emit("delete", gson.toJson(new StudyRoomModel(roomTitle)));
        //소켓 disconnect
        mSocket.disconnect();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

}