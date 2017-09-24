package com.gmail.androiddz.dz11.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.androiddz.R;
import com.gmail.androiddz.TestApplication;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz11ProfileBinding;
import com.gmail.androiddz.domain.interaction.GetProfileUseCase;
import com.gmail.androiddz.dz11.ClickHandler;

import javax.inject.Inject;

public class ProfileActivity extends BaseActivity {

    @Inject
    GetProfileUseCase getProfileUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TestApplication.appComponent.inject(this);

        String id = getIntent().getStringExtra("ID");
        ProfileViewModel viewModel = new ProfileViewModel(id, getProfileUseCase);

        this.viewModel = viewModel;

        ActivityDz11ProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz11_profile);
        binding.setProfile(viewModel);
        binding.setHandler(new ClickHandler(ProfileActivity.this));

        super.onCreate(savedInstanceState);
    }
}
