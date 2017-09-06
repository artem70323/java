package com.gmail.androiddz.dz11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.androiddz.base.BaseAdapter;
import com.gmail.androiddz.domain.entity.ProfileDomain;

public class ProfileAdapter extends BaseAdapter<ProfileDomain, ProfileItemViewModel> {

    @Override
    public ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}