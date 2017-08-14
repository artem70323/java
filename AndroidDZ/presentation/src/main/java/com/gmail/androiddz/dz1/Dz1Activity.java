package com.gmail.androiddz.dz1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.androiddz.R;

public class Dz1Activity extends Activity implements View.OnClickListener {

    private Button changeButton;
    private TextView view1;
    private TextView view2;

    View.OnClickListener view = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            change();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz1);
        Log.d("MainActivity", "onCreate()");
        view1 = (TextView) findViewById(R.id.textView1);
        view2 = (TextView) findViewById(R.id.textView2);
        changeButton = (Button) findViewById(R.id.change_button);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });

        view1.setOnClickListener(view);
        view2.setOnClickListener(this);
    }

    private void change() {
        String temp = (String) view1.getText();
        view1.setText(view2.getText());
        view2.setText(temp);
    }

    @Override
    public void onClick(View v) {
        change();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }
}
