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

import android.widget.ImageView;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.MainBestMemberAdapter;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.MainBestMemberModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
//public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG = "MainActivity";
    TextView tv_searchBar;
    ViewPager viewpager;
    ImageView img_profile;

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

        //베스트 멤버에 필요한 데이터 models 변수에 담아
        models = new ArrayList<>();
        models.add(new MainBestMemberModel("분야"));
        models.add(new MainBestMemberModel("나이이"));

        //어댑터 생성시 보냄.
        adapter = new MainBestMemberAdapter(models, this);
        viewpager.setPadding(0, 0, 50, 0); //오른쪽에 padding을 줘서 2번째 슬라이더가 살짝 보이게 함
        viewpager.setAdapter(adapter); //어댑터 설정

        // * 베스트 멤버 뷰페이지 이벤트 처리
        // (수정) 나중에 '지원'이 수정하겠음. 어댑터의 이벤트처리랑 좀 혼동이 있어서.. 보류
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tv_searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

        img_profile = findViewById(R.id.img_profile);

        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
                startActivity(intent);
            }
        });

        // 이미지 프로필 터지로 다이얼로그 이벤트 테스트

//        img_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //PauseDialog pauseDialog = new PauseDialog(MainActivity.this);
//
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setCanceledOnTouchOutside(false); // 다이얼로그 밖을 터치했을 때
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.setContentView(R.layout.dialog_pause);
//
//                final Button btn_exit = dialog.findViewById(R.id.btn_exit);
//
//                btn_exit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });

    }

    //** 리스너 인터페이스를 상속받고 아래처럼 구현하는게 클릭이벤트가 많을 때는 훨씬 깔끔한데,
    //** 무슨 이유에서 인지 이벤트가 발생하지 않음. 시도중.

    /*--------------------------------------------------------------------
       onClick 이벤트 처리
     *--------------------------------------------------------------------*/
/*

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

            case R.id.img_profile: // 프로필 이미지
                // 마이페이지로 넘어감
                //Intent intent = new Intent(getApplicationContext(), -- );


        }
    }
    */

}