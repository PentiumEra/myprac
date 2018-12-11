package com.example.myremoteview;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRemote();
    }

    private void initRemote() {
        Notification notification=new Notification();
        notification.iconLevel=R.drawable.ic_launcher_background;
        notification.tickerText="hello World";
        notification.when=System.currentTimeMillis();
        notification.flags=Notification.FLAG_AUTO_CANCEL;
    }
}
