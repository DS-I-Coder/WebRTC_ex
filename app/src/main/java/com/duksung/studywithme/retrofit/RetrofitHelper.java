package com.duksung.studywithme.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.214.1:8000") // ip주소 뒤에는 포트번호
                   // .baseUrl("http://192.168.0.3:8000") // ip주소 뒤에는 포트번호
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    /*
    ip 주소 날마다 바뀌는데... 혹시 그런 경우는 할 때마다 확인하거나, ip주소를 아예 고정시키는 방법이 있음
     */
}
