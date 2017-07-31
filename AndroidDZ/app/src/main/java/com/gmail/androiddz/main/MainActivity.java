package com.gmail.androiddz.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gmail.androiddz.R;
import com.gmail.androiddz.dz1.Dz1Activity;
import com.gmail.androiddz.dz2.Dz2Activity;
import com.gmail.androiddz.dz3.Dz3Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        Button dz2Button = (Button) findViewById(R.id.dz2Button);
        Button dz3Button = (Button) findViewById(R.id.dz3Button);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.dz1Button:
                        intent = new Intent(MainActivity.this, Dz1Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.dz2Button:
                        intent = new Intent(MainActivity.this, Dz2Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.dz3Button:
                        intent = new Intent(MainActivity.this, Dz3Activity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        dz1Button.setOnClickListener(onClickListener);
        dz2Button.setOnClickListener(onClickListener);
        dz3Button.setOnClickListener(onClickListener);

    }
}
