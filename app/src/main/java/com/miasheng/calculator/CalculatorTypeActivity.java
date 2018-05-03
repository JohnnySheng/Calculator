package com.miasheng.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculatorTypeActivity extends AppCompatActivity {
    public TextView mTextView1;
    public RadioGroup mRadioGroup1;
    public RadioButton mRadio1;
    public RadioButton mRadio2;
    public RadioButton mRadio3;
    public RadioButton mRadio4;
    public String txtViewString;
    public String calTypeString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_type);

        // 取得 TextView、RadioGroup、RadioButton对象
        mTextView1 = findViewById(R.id.cal_type_title);

        txtViewString = (String) mTextView1.getText();

        mRadioGroup1 =  findViewById(R.id.radio_group);
        mRadio1 =  findViewById(R.id.radioButton1);
        mRadio2 =  findViewById(R.id.radioButton2);
        mRadio3 =  findViewById(R.id.radioButton3);
        mRadio4 =  findViewById(R.id.radioButton4);

        // RadioGroup用OnCheckedChangeListener来运行
        mRadioGroup1.setOnCheckedChangeListener(mChangeRadio);
    }

    private RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // TODO Auto-generated method stub
            if (checkedId == mRadio1.getId()) {
                calTypeString = (String) mRadio1.getText();
            } else if (checkedId == mRadio2.getId()) {
                calTypeString = (String) mRadio2.getText();
            }else if (checkedId == mRadio3.getId()) {
                calTypeString = (String) mRadio3.getText();
            }else{
                calTypeString = (String) mRadio4.getText();
            }

            // 把mRadio的内容传到mTextView1
            String combinedString = txtViewString + calTypeString;
            mTextView1.setText(combinedString);
        }
    };


    public void confirmSelection(View view){
        Intent intent = getIntent();

        intent.putExtra("caltype", calTypeString);
        /*给上一个Activity返回结果*/
        this.setResult(RESULT_OK,intent);
        /*结束本Activity*/
        this.finish();
    }

}
