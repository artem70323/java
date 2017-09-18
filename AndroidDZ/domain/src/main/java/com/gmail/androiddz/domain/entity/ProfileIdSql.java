package com.gmail.androiddz.domain.entity;

import android.content.Context;

public class ProfileIdSql {

    private int id;
    private Context context;

    public ProfileIdSql(int id, Context context) {
        this.id = id;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
