package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.duksung.studywithme.R;
import com.duksung.studywithme.model.TestModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestAActivity extends AppCompatActivity {

    EditText et_name, et_age, et_address;
    Button btn_submit;
    RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_address = findViewById(R.id.et_address);
        btn_submit = findViewById(R.id.btn_submit);

        retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<TestModel> call
                        = retrofitService.getUserCheck(et_name.getText().toString(),
                        Integer.parseInt(et_age.getText().toString()), et_address.getText().toString(
                        ));

                call.enqueue(new Callback<TestModel>() {
                    @Override
                    public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                        // 통신 성공
                        TestModel testModel = response.body();  //서버에서 받아온 json 형태 받음
                        Log.d("ssssszs", testModel.getAddress());
                        Log.d("ssssszs", testModel.getAge()+"");
                        Log.d("ssssszs", testModel.getName());
                        //화면 전환 할 때 intent에다가 값을 넣을 수 있음
                        Intent intent = new Intent(getApplicationContext(), TestBActivity.class);
                        intent.putExtra("name", testModel.getName());
                        intent.putExtra("age", testModel.getAge());
                        intent.putExtra("address", testModel.getAddress());

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<TestModel> call, Throwable t) {
                        // 통신 실패
                        Log.d("sssss", "실패");
                        //애뮬레이터 여러개 사용하거나 본인 휴대폰 기기 연결해서 쓸 때, logcat 왼쪽 상단에
                        //실행한 기기로 잘 되어있나 확인.
                        t.printStackTrace();
                    }
                });

            }
        });
    }
}
