package com.gmail.androiddz.dz9;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gmail.androiddz.R;
import com.gmail.androiddz.base.BaseActivity;

public class Dz9Activity extends BaseActivity {



    private RecyclerView recyclerView;

    private String[] android_image_urls;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_dz9);
        initViews();
        Dz9ViewModel viewModel = new Dz9ViewModel();
        this.viewModel = viewModel;
        android_image_urls = viewModel.android_image_urls;
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        Dz9Adapter adapter = new Dz9Adapter(android_image_urls);
        recyclerView.setAdapter(adapter);
    }

}
