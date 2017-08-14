package com.gmail.androiddz.dz7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.androiddz.R;
import com.gmail.androiddz.databinding.ActivityDz7Binding;

public class Dz7Activity extends Activity {

    public Dz7User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createUser();
        ActivityDz7Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz7);
        binding.setUser(user);
    }

    private void createUser() {
        user = new Dz7User();
        user.imageUrl = "https://pp.userapi.com/c618825/v618825839/18a42/T2KOv3fDEtY.jpg";
        user.isMan = true;
        user.name = "Artsiom";
        user.surname = "Basharkevich";
        user.age = 24;
    }
}
