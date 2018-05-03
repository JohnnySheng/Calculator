package com.miasheng.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText editText1;
    public EditText editText2;
    private String calType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();

        if (bundle != null){
            /*获取Bundle中的数据，注意类型和key*/
            this.calType = bundle.getString("caltype");
            TextView textView =  findViewById(R.id.textView);
            textView.setText(this.calType);
        }
    }

    public void showSelectionPage(View view){
        Intent intent = new Intent(this, CalculatorTypeActivity.class);
        startActivityForResult(intent,1);
    }

    public void calculateValue(View view){
        String text1 = (String) this.editText1.getText().toString();
        String text2 = (String) this.editText2.getText().toString();
        double value1 = Double.valueOf(text1).doubleValue();
        double value2 = Double.valueOf(text2).doubleValue();
        double result = 0;

        if (this.calType.equals(this.getString(R.string.cal_add))){
            result = value1 + value2;
        }else if (this.calType.equals(this.getString(R.string.cal_minus))){
            result = value1 - value2;
        }else if (this.calType.equals(this.getString(R.string.cal_multiply))){
            result = value1 * value2;
        } else{
            result = value1/value2;
        }

        TextView resultTextView = findViewById(R.id.result_textview);

        resultTextView.setText(String.valueOf(result));

    }
}
