package com.duksung.studywithme.common.preferences;

public class AppData {

    /**
     * 앱 자체 db
     * 가벼운 정보를 저장하는데 쓰임. 특히 매번 서버에서 값을 받아올 필요가 없는 것들(ex. 프로필 사진, 닉네임 등등)
     * IPreference -> SharedPreferences가 key, value 형태로 저장되는데 이 과정을 간단히 하기 위한 클래스
     * 만들어두기만하고 AppData에서 이용하면 됨.
     *
     * 이 부분은 지원이 한 적이 있어서 만들 수는 있으나, 갑자기 Sharedpreferences를 안쓴다는 인터넷 글을 보고
     * 좀 더 조사 중이여서 신경쓰지 않아도 됨.
     */
}
