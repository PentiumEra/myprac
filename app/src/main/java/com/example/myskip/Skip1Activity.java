package com.example.myskip;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amber.myprac.R;

public class Skip1Activity extends AppCompatActivity {
    private Button button;
    private final static int REQUESTCODE = 1; // 返回的结果码
    private EditText one, two, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip1);
        initView();
    }

    private void initView() {
        button=findViewById(R.id.button);
        one=findViewById(R.id.Text_one);
        two=findViewById(R.id.Text_two);
        result=findViewById(R.id.Text_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的两个值
                int a = Integer.parseInt(one.getText().toString());
                int b = Integer.parseInt(two.getText().toString());
                Intent intent=new Intent(Skip1Activity.this,SkipTwoActivity.class);
                intent.putExtra("a",a);
                intent.putExtra("b",b);
                startActivityForResult(intent,REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                int three = data.getIntExtra("three", 0);
                //设置结果显示框的显示数值
                result.setText(String.valueOf(three));
            }
        }
    }
}
