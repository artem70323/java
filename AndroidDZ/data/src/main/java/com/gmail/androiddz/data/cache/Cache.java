package com.gmail.androiddz.data.cache;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Cache {

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;
    private static final String SETTINGS_FILE_NAME = "Time";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "lastCacheUpdate";

    private Context context;
    private FileManager fileManager;

    @Inject
    public Cache(Context context, FileManager fileManager) {
        this.context = context;
        this.fileManager = fileManager;
    }

    public void put(List<ProfileData> dataList) {
        fileManager.saveUsers(dataList);
        setLastCacheUpdateTimeMillis();
    }

    public List<ProfileData> get() {
        return fileManager.getUsers();
    }

    public boolean isThereInternetConnection() {

        boolean isConnected;

        boolean cont = context == null;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }

    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            deleteAll();
        }

        return expired;
    }

    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    private void setLastCacheUpdateTimeMillis() {
        final long currentMillis = System.currentTimeMillis();
        fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    private void deleteAll() {
        fileManager.deleteAll();
    }

}
