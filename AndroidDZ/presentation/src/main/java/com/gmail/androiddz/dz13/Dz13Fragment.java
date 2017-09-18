package com.gmail.androiddz.dz13;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.androiddz.R;
import com.gmail.androiddz.databinding.FragmentDz13Binding;


public class Dz13Fragment extends Fragment {

    private Dz13User user;

    public Dz13Fragment() {
    }


    public static Dz13Fragment newInstance() {
        return new Dz13Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createUser();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDz13Binding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dz13, container, false);
        binding.setUser(user);
        return binding.getRoot();
    }

    private void createUser() {
        user = new Dz13User();
        user.imageUrl = "https://pp.userapi.com/c618825/v618825839/18a42/T2KOv3fDEtY.jpg";
        user.isMan = true;
        user.name = "Artsiom";
        user.surname = "Basharkevich";
        user.age = 24;
    }
}
