package com.gmail.androiddz.dz7;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Dz7User {

    public String imageUrl;
    public boolean isMan;
    public String name;
    public String surname;
    public int age;

    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

}
