package com.demos.softreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);

        textView.setOnClickListener(click);
    }


    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("dianji");
            new MyHandler(MainActivity.this).sendEmptyMessageDelayed(0x11,3000);
        }
    };


}
