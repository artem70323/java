package com.gmail.androiddz.dz5;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.gmail.androiddz.R;

public class Dz5Activity extends Activity {

    public static final String BROADCAST_ACTION = "com.gmail.androiddz.dz5";
    public static final String WIFI_STATUS = "Wi-Fi Status";
    private TextView textView;
    private Intent intent;
    private IntentFilter intentFilter;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Wi-Fi status");
        intent = new Intent(this, MyService.class);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                textView.setText(intent.getStringExtra(WIFI_STATUS));
            }
        };

        intentFilter = new IntentFilter(BROADCAST_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(intent);
        Log.e("Wi-Fi", "startService");
        registerReceiver(receiver, intentFilter);
        Log.e("Wi-Fi", "dz5ActivityRegisterReceiver");
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
        Log.e("Wi-Fi", "stopService");
        unregisterReceiver(receiver);
        Log.e("Wi-Fi", "dz5ActivityUnregisterReceiver");
    }

}
