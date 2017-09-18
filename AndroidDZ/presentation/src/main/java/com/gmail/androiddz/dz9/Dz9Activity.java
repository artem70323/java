package com.gmail.androiddz.dz9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;
import com.gmail.androiddz.databinding.ActivityDz9Binding;

public class Dz9Activity extends BaseActivity {

    private String[] androidImageUrls;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Fresco.initialize(this);
        ActivityDz9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz9);
        Dz9ViewModel viewModel = new Dz9ViewModel();
        this.viewModel = viewModel;

        super.onCreate(savedInstanceState);

        androidImageUrls = viewModel.androidImageUrls;
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        binding.recyclerView.setAdapter(new Dz9Adapter(androidImageUrls));
    }

}
