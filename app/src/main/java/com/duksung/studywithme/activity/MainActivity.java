package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.MainBestMemberAdapter;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.MainBestMemberModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG = "MainActivity";
    TextView tv_searchBar;
    ViewPager viewpager;
    ImageView img_profile, img_addRoom;
    FloatingActionButton floatingBtn_userInfo;
    List<MainBestMemberModel> models;
    MainBestMemberAdapter adapter;
    RetrofitService retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_searchBar = findViewById(R.id.tv_searchBar);
        viewpager = findViewById(R.id.main_viewpager);
        img_profile = findViewById(R.id.img_profile);
        img_addRoom = findViewById(R.id.img_addRoom);
        floatingBtn_userInfo = findViewById(R.id.floatingBtn_userInfo);

        //이벤트 등록
        tv_searchBar.setOnClickListener(this);
        img_profile.setOnClickListener(this);
        floatingBtn_userInfo.setOnClickListener(this);

        setAdapter();

    }

    private void setAdapter(){
        //베스트 멤버에 필요한 데이터 models 변수에 담아
        models = new ArrayList<>();
        models.add(new MainBestMemberModel("분야"));
        models.add(new MainBestMemberModel("나이이"));

        //어댑터 생성시 보냄.
        adapter = new MainBestMemberAdapter(models, this);
        viewpager.setPadding(0, 0, 50, 0); //오른쪽에 padding을 줘서 2번째 슬라이더가 살짝 보이게 함
        viewpager.setAdapter(adapter); //어댑터 설정
    }

    /*--------------------------------------------------------------------
       onClick 이벤트 처리
     *--------------------------------------------------------------------*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_searchBar: // 검색바

                Log.d(TAG,"searchBar EVENT");
                retrofitService.getCategory().enqueue(new Callback<ArrayList<CategoryModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<CategoryModel>> call, Response<ArrayList<CategoryModel>> response) {
                        Log.d(TAG, "response");
                        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                        intent.putExtra("category", response.body()); //현재 존재하는 카테고리 받아서 넘김.
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.not_move); // 화면전환 애니메이션
                    }

                    @Override
                    public void onFailure(Call<ArrayList<CategoryModel>> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
                break;


            case R.id.img_profile: // 마이페이지 아이콘
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class );
                startActivity(intent);
                break;

            case R.id.img_addRoom: // 스터디룸 추가 아이콘
                Intent intent2 = new Intent(getApplicationContext(), MakeStudyRoom.class );
                startActivity(intent2);
                break;

            case R.id.floatingBtn_userInfo: //플로팅 버튼

                // 임시 다이얼로그 : 처음에 누적시간 용도로 만들어서 이름이 pause인 것.
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setCanceledOnTouchOutside(false); // 다이얼로그 밖을 터치했을 때
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_pause);

                final Button btn_exit = dialog.findViewById(R.id.btn_exit);

                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;

        }
    }
}