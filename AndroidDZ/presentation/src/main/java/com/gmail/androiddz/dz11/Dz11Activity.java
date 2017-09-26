package com.gmail.androiddz.dz11;

import com.gmail.androiddz.R;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.gmail.androiddz.TestApplication;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz11Binding;

import javax.inject.Inject;

public class Dz11Activity extends BaseActivity {

    @Inject
    Dz11ViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((TestApplication)getApplication()).getAppComponent().inject(this);

        super.viewModel = viewModel;

        ActivityDz11Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz11);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }

}