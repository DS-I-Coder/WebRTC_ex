package com.duksung.studywithme.common;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 공통부분 선언. 보통 변하지 않는 주소나, 자주쓰는 함수 작성.
 */
public class Common {
    // static final 변수 선언

    public static final String BASE_SERVER_URL = "https://192.168.0.21:3000";  // ip주소
//    public static final String BASE_SERVER_URL = "http://192.168.214.1:3000";

    public static final String SearchRoomURL = "/mainpage/search";      // 방 검색
    public static final String GetCategoryURL = "/mainpage/category";   // 카테고리 조회


    /** 빈 문자열 체크 **/
    public static boolean isStringEmpty(@Nullable String str){
        if(str == null || str.trim().isEmpty()){
            return true;
        }
        return false;
    }

    /** dp를 px 단위로 **/
    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}
