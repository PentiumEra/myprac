package com.example.myskip;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.amber.myprac.R;

public class SkipTwoActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    public static void startSkipTwoActivity(Context context){
        try {
            Intent intent = new Intent(context, SkipTwoActivity.class);
            context.startActivity(intent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_two);
        initView();
        Intent intent=getIntent();
        int a=intent.getIntExtra("a",0); // 没有默认输入为0
        int b=intent.getIntExtra("b",0);
        textView.setText(a + " + " + b + " = " + " ? ");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                int three = Integer.parseInt(editText.getText().toString());
                intent.putExtra("three", three); //将计算的值回传回去
                //通过intent对象返回结果，必须要调用一个setResult方法，
                //setResult(resultCode, data);第一个参数表示结果返回码，一般只要大于1就可以，但是
                setResult(2, intent);
                finish(); //结束当前的activity的生命周期
            }
        });
    }
    private void initView() {
        button = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.msg);
        editText = (EditText) findViewById(R.id.Text_three);
    }
}
