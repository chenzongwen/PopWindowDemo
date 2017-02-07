package com.ownchan.popwindowdemo;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_view);

        LayoutInflater inflater = LayoutInflater.from(this);
        RelativeLayout popView = (RelativeLayout) inflater.inflate(R.layout.pop_view, null);
        final CustomPopWindow customPopWindow = new CustomPopWindow(popView, textView);
        customPopWindow.setCallBack(new CustomPopWindow.CallBack() {
            @Override
            public void onStateChanged(int state) {
                Toast.makeText(MainActivity.this, "state: " + state, Toast.LENGTH_LONG).show();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customPopWindow.showPopWindow();
            }
        });
    }
}
