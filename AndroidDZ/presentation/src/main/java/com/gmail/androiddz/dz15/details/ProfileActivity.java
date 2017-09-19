package com.gmail.androiddz.dz15.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz15ProfileBinding;
import com.gmail.androiddz.dz15.ClickHandler;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int id = getIntent().getIntExtra("ID", 0);
        ProfileViewModel viewModel;

        if (id == -666) {
            viewModel = new ProfileViewModel(this);
        } else {
            viewModel = new ProfileViewModel(id, this);
        }
        this.viewModel = viewModel;

        ActivityDz15ProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz15_profile);
        binding.setProfile(viewModel);
        binding.setHandler(new ClickHandler(this));

        SpinnerViewModel spinnerViewModel = new SpinnerViewModel(this);
        binding.spinnerDz15.setAdapter(spinnerViewModel.adapter);
        binding.spinnerDz15.setOnItemSelectedListener(spinnerViewModel);

        super.onCreate(savedInstanceState);
    }
}
