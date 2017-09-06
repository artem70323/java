package com.gmail.androiddz.dz11;

import com.gmail.androiddz.R;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz11Binding;

public class Dz11Activity extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Dz11ViewModel viewModel = new Dz11ViewModel(this);
        this.viewModel = viewModel;

        ActivityDz11Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz11);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }

}