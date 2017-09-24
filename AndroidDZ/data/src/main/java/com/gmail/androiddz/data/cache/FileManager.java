package com.gmail.androiddz.data.cache;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;

public class FileManager {

    FileManager() {}

    private Realm realm;

    void saveUsers(final List<ProfileData> dataList) {
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                deleteAll();
//                RealmList<ProfileData> realmList = new RealmList<>();
//                realmList.addAll(dataList);
                realm.copyToRealmOrUpdate(dataList);
                Log.e("saveUsers", "saveUsers");
            }
        });
    }

    List<ProfileData> getUsers() {
        realm = Realm.getDefaultInstance();
        RealmResults<ProfileData> results = realm.where(ProfileData.class).findAll();
        List<ProfileData> list = realm.copyFromRealm(results);
        Log.e("getUsers", "getUsers");
        Log.e("User", list.get(1).getName());
        return list;
    }

    void deleteAll() {
        RealmResults<ProfileData> results = realm.where(ProfileData.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

    void writeToPreferences(Context context, String preferenceFileName, String key, long value) {

        final SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    long getFromPreferences(Context context, String preferenceFileName, String key) {

        final SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }


}
