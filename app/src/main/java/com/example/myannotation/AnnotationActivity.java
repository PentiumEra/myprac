package com.example.myannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.amber.myprac.R;

public class AnnotationActivity extends AppCompatActivity {
    @ViewById(R.id.myannotation)
    TextView tv1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
    }
}
