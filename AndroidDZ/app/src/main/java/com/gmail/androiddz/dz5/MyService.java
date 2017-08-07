package com.gmail.androiddz.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    WifiManager wifiManager;
    Intent myIntent = new Intent(Dz5Activity.BROADCAST_ACTION);
    private IntentFilter intentFilter;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            Log.e("Wi-Fi", "Wifi enabled: " + wifiManager.isWifiEnabled());
            myIntent.putExtra(Dz5Activity.WIFI_STATUS, "Wifi enabled: " + wifiManager.isWifiEnabled());
            sendBroadcast(myIntent);
        }
    };

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        registerReceiver(receiver, intentFilter);
        Log.e("Wi-Fi", "serviceRegisterReceiver");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.e("Wi-Fi", "serviceUnregisterReceiver");
    }
}
