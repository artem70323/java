package com.gmail.androiddz.dz15;

import android.content.Context;
import android.content.Intent;

import com.gmail.androiddz.domain.entity.ProfileIdSql;
import com.gmail.androiddz.dz15.details.ProfileViewModel;
import com.gmail.androiddz.dz15.details.ProfileActivity;

public class ClickHandler {
    private Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onItemClick(ProfileIdSql id) {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("ID", id.getId());
        context.startActivity(intent);
    }

    public void addUser() {
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("ID", -666);
        context.startActivity(intent);
    }

    public void onSaveProfile(ProfileViewModel profile) {
        profile.saveProfile();
    }
}
