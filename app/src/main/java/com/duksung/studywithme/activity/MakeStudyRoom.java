package com.duksung.studywithme.activity;

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

public class MakeStudyRoom extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private ImageView img_backToMain;
    private EditText et_studyName, et_studyField,et_setStudyPassword;
    private Button btn_makeStudyRoom;
    private RadioButton radioBtn_private;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_study_room);

        img_backToMain = findViewById(R.id.img_backToMain);
        btn_makeStudyRoom = findViewById(R.id.btn_makeStudyRoom);

        radioButtonInit();
        btn_makeStudyRoom.setOnClickListener(this);
        btn_makeStudyRoom.setClickable(true);

        et_studyName = findViewById(R.id.et_studyName);
        et_studyField = findViewById(R.id.studyField);

        et_studyName.addTextChangedListener(this);
        et_studyField.addTextChangedListener(this);

    }


    /*--------------------------------------------------------------------
       onClick 이벤트 처리
     *--------------------------------------------------------------------*/

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_backToMain: // 뒤로가기버튼인
                finish();
                break;


            case R.id.btn_makeStudyRoom:
                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
                break;


        }
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
                }

            }
        });

    }

    private boolean isAllFilled(){

        if( Common.isStringEmpty(et_studyName.getText().toString())
            && Common.isStringEmpty(et_studyField.getText().toString())){
            // 하나라도 채워진 내용이 있다면
            return false;
        }

        if(radioBtn_private.isChecked()){ //private 체크인경우 비밀번호 설정했는지 확
            if (Common.isStringEmpty(et_setStudyPassword.getText().toString())){
                return false;
            }
        }

        return true;
    }

    /**
     * TextWatcher() 메소드
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

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

    @Override
    public void afterTextChanged(Editable s) {

    }
}