package com.duksung.studywithme.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;
import com.google.android.material.textfield.TextInputEditText;

public class MakeStudyRoom extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private ImageView img_backToMain;
    private EditText et_studyName, et_studyField,et_setStudyPassword;
    private TextView tv_cameraSetting, tv_micSetting, tv_speakerSetting;
    private TextInputEditText et_studyNotice;
    private Button btn_makeStudyRoom;
    private RadioButton radioBtn_private;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_study_room);

        setListener();
        radioButtonInit();

    }

    private void setListener(){
        img_backToMain = findViewById(R.id.img_backToMain);
        btn_makeStudyRoom = findViewById(R.id.btn_makeStudyRoom);
        et_studyName = findViewById(R.id.et_studyName);
        et_studyField = findViewById(R.id.studyField);
        et_studyNotice = findViewById(R.id.et_studyNotice);
        tv_cameraSetting = findViewById(R.id.tv_cameraSetting);
        tv_micSetting = findViewById(R.id.tv_micSetting);
        tv_speakerSetting = findViewById(R.id.tv_speakerSetting);

        et_studyName.addTextChangedListener(this);
        et_studyField.addTextChangedListener(this);
        et_studyNotice.addTextChangedListener(this);

        btn_makeStudyRoom.setOnClickListener(this);
        img_backToMain.setOnClickListener(this);
        tv_cameraSetting.setOnClickListener(this);
        tv_micSetting.setOnClickListener(this);
        tv_speakerSetting.setOnClickListener(this);
    }

    private void radioButtonInit() {
        RadioGroup radioGroup_studyAccess = findViewById(R.id.radioGroup_studyAccess);
        RadioButton radioBtn_public = findViewById(R.id.radioBtn_public);
        radioBtn_private = findViewById(R.id.radioBtn_private);

        LinearLayout layout_setRoomPassword = findViewById(R.id.layout_setRoomPassword);

        radioBtn_public.setChecked(true);  // 디폴트로 public에 체크되어있게 함.

        //* RadioGroup 이벤트 - 그룹으로 이벤트 설정을하고 안에서 조건으로 버튼들을 구분해야 배타선택이 가능.
        radioGroup_studyAccess.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn_public) {        //PUBLIC
                    layout_setRoomPassword.setVisibility(View.GONE); // 하단 비밀번호 설정레이아웃 사라짐
                    // (invisible은 보이진 않지만, 자리는 차지하므로 gone으로 값을 줘야함)

                } else if (checkedId == R.id.radioBtn_private) {    // PRIVATE
                    layout_setRoomPassword.setVisibility(View.VISIBLE);

                    if(!isAllFilled()){
                        btn_makeStudyRoom.setBackgroundResource(R.drawable.button_inactive_gray_border);
                    }
                }

            }
        });

    }

    private boolean isAllFilled(){  // 내용이 전부 채워졌는지 확인

        if( Common.isStringEmpty(et_studyName.getText().toString())
            || Common.isStringEmpty(et_studyField.getText().toString())
            || Common.isStringEmpty(et_studyNotice.getText().toString())){
            // 하나라도 비어있다면 return false
            return false;
        }

        if(radioBtn_private.isChecked()){ //private 체크인경우 비밀번호 설정했는지 확
            if (Common.isStringEmpty( et_setStudyPassword.getText().toString())){
                return false;
            }
        }

        return true;
    }

    /*--------------------------------------------------------------------
       onClick, TextWatcher 이벤트 처리
     *--------------------------------------------------------------------*/

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.img_backToMain){             // 뒤로가기 버튼

        }
        else if (v.getId() == R.id.btn_makeStudyRoom){  // 하단 MAKE STUDY ROOM 버튼

        }
        else if(v.getId() == R.id.tv_cameraSetting) {
            toggleSettingChip(tv_cameraSetting);
        }
    }

    private void toggleSettingChip(TextView textView){

    }

    //* editText 텍스트 입력 전
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    //* editText 텍스트 입력 중
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(isAllFilled()){
            btn_makeStudyRoom.setEnabled(true);
            btn_makeStudyRoom.setBackgroundResource(R.drawable.button_active_darkblue_border);
        }else{
            btn_makeStudyRoom.setEnabled(false);
            btn_makeStudyRoom.setBackgroundResource(R.drawable.button_inactive_gray_border);
        }
    }

    //* editText 텍스트 입력 완료 후
    @Override
    public void afterTextChanged(Editable s) {

    }
}