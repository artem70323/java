package com.gmail.androiddz.dz11.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz11ProfileBinding;
import com.gmail.androiddz.dz11.ClickHandler;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String id = getIntent().getStringExtra("ID");
        ProfileViewModel viewModel = new ProfileViewModel(id);

        this.viewModel = viewModel;

        ActivityDz11ProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz11_profile);
        binding.setProfile(viewModel);
        binding.setHandler(new ClickHandler(ProfileActivity.this));

        super.onCreate(savedInstanceState);
    }
}
