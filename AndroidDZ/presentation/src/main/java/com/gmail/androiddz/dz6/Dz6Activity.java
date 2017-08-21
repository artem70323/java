package com.gmail.androiddz.dz6;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gmail.androiddz.R;

public class Dz6Activity extends Activity {

    private RecyclerView recyclerView;

    private final String[] ANDROID_IMAGE_URLS = {
            "https://i01.fotocdn.net/s16/123/gallery_xs/259/30343802.jpg",
            "https://i01.fotocdn.net/s16/104/gallery_xs/233/9365607.jpg",
            "https://i09.fotocdn.net/s8/205/gallery_m/159/2254347980.jpg",
            "https://i10.fotocdn.net/s16/86/gallery_xs/493/9694293.jpg",
            "https://i05.fotocdn.net/s16/77/gallery_xs/126/32013644.jpg",
            "https://i01.fotocdn.net/s5/226/gallery_xs/341/2180863201.jpg",
            "https://i02.fotocdn.net/s5/202/gallery_xs/54/2189178313.jpg",
            "https://i03.fotocdn.net/s19/30/gallery_xs/2/1066664221.jpg",
            "https://i03.fotocdn.net/s5/147/gallery_xs/341/2180863122.jpg",
            "https://i02.fotocdn.net/s19/165/gallery_xs/239/1073802916.jpg",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_dz6);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        Dz6Adapter adapter = new Dz6Adapter(ANDROID_IMAGE_URLS);
        recyclerView.setAdapter(adapter);
    }

}
