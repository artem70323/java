package com.gmail.androiddz.dz9;

import android.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

public class ItemViewModel {

    public String imageUrl;

    public ItemViewModel(String position) {
        imageUrl = position;
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(SimpleDraweeView view, String imageUrl) {
        view.setImageURI(imageUrl);
    }
}
