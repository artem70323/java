package com.gmail.androiddz.dz4;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.gmail.androiddz.R;

public class Dz4Activity extends Activity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz4);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.sova_animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
}
