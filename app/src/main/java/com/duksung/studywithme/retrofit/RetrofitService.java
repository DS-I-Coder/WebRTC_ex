package com.duksung.studywithme.retrofit;

import com.duksung.studywithme.model.TestModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @FormUrlEncoded     // post 메소드 할 땐 붙여줘야함.
    @POST("/tests/")     // Helper에 지정해준 baseurl 뒤에 붙는 주소 쓰면 됨
    Call<TestModel> getUserCheck(@Field("name") String name,
                                 @Field("age") int age,
                                 @Field("address") String address);
    
    /* GET 형태
    @GET("주소")
    Call<반환모델> 함수이름(@Query("변수") 타입 변수명)
    */
//    @GET("")
//    Call<TestModel> getUser(@Query("name") String name,
//                            @Query("age") int age,
//                            @Query("address") String address);

}
