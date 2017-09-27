package com.artyombash.presentation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.artyombash.presentation.FootballApplication;
import com.artyombash.presentation.databinding.ActivityMainBinding;
import com.artyombash.presentation.viewModel.MainViewModel;
import com.artyombash.presentation.R;
import com.artyombash.presentation.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((FootballApplication)getApplication()).getAppComponent().inject(this);

        super.viewModel = viewModel;
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }

}
