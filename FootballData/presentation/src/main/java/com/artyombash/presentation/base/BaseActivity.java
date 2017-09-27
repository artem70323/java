package com.artyombash.presentation.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;


public abstract class BaseActivity extends Activity {

    protected BaseViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.destroy();
    }
}
