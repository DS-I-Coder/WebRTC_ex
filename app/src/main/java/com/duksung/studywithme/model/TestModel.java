package com.duksung.studywithme.model;

import com.google.gson.annotations.SerializedName;

public class TestModel {
    //test에서는 보내는 값과 서버에서 오는 값이 동일해서 헷갈릴 수 있지만 testmodel은
    //성공적으로 서버 연결이 됐을 때, 서버에서 주는 값.

    @SerializedName("name")   // json에서  key값(변수명)이랑 mapping. 괄호 안이  json에 있는 이름
            String name;  // 여기가 안드로이드에서 쓸 변수명. 보통은 동일하게 함

    @SerializedName("age")
    int age;

    @SerializedName("address")
    String address;

    // 여기까지 서버에서 받아오는 변수들을 선언했으면, 우클릭 > Generate로 생성자와 getter&setter 만들면 됨
    // generate 단축키 알아두면 편함
    // 사실 setter가 필요한지는 잘 모르겠어서 일단은 getter만 만들어도 상관 없을듯?

    public TestModel(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
