package com.gmail.androiddz.dz10;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz10Binding;

public class Dz10Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityDz10Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz10);
        Dz10ViewModel viewModel = new Dz10ViewModel();
        this.viewModel = viewModel;
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
