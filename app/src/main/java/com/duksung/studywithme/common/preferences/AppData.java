package com.duksung.studywithme.common.preferences;

import android.content.Context;

public class AppData extends IPreference {

    /**
     * 비교적 적은 양의 key-value값을 저장.
     */

    private static AppData mInstance; // 싱글톤 패턴 적용하기 위해 정적변수로 선언

    public static synchronized AppData getInstance(Context context){ // 싱글톤 메서드: 앱 내 단 하나의 객체만이 존재하게 함
        if (mInstance == null){
            mInstance = new AppData(context);
        }
        return mInstance;
    }

    //
    public AppData(Context context){

    }

    private final String PREF_LOGIN_ID = "loginID"; // key값

    public void setPREF_LOGIN_ID(String string){ putString(PREF_LOGIN_ID, string); }
    public String getPREF_LOGIN_ID() {
        return getString(PREF_LOGIN_ID);
    }
}
