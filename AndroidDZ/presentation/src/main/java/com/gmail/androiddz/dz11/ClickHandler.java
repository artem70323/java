package com.gmail.androiddz.dz11;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.gmail.androiddz.domain.entity.ProfileId;
import com.gmail.androiddz.dz11.details.ProfileActivity;
import com.gmail.androiddz.dz11.details.ProfileViewModel;

public class ClickHandler {
    private Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onItemClick(ProfileId id) {
        Log.e("AAAA", "onItemClick");
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("ID", id.getId());
        context.startActivity(intent);
    }

    public void onProfileEdit(ProfileViewModel profile) {
        profile.state.set(ProfileViewModel.STATE.EDIT);
    }

    public void onSaveProfile(ProfileViewModel profile) {
        profile.saveProfile();
    }
}
