package com.gmail.androiddz.dz14;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz14Binding;

public class Dz14Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityDz14Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz14);
        Dz14ViewModel viewModel = new Dz14ViewModel(this);
        this.viewModel = viewModel;
        binding.spinnerDz14.setAdapter(viewModel.adapter);
        binding.spinnerDz14.setOnItemSelectedListener(viewModel);
        binding.spinnerDz14.setSelection(viewModel.countryListSelectedPosition);
        super.onCreate(savedInstanceState);
    }

}
