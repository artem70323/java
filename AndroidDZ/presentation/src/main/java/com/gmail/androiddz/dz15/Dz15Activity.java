package com.gmail.androiddz.dz15;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz15Binding;

public class Dz15Activity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Dz15ViewModel viewModel = new Dz15ViewModel(this);
        this.viewModel = viewModel;
        super.onCreate(savedInstanceState);

        ActivityDz15Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz15);

//        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

    }

}
