package com.gmail.androiddz.dz13;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.gmail.androiddz.R;

public class Dz13Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz13);

//        FragmentManager fragmentManager = getSupportFragmentManager();
        showFragment(getSupportFragmentManager(), Dz13Fragment.newInstance());
    }

    private void showFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
