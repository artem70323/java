package com.gmail.androiddz.dz11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.androiddz.base.BaseItemViewHolder;
import com.gmail.androiddz.databinding.ItemProfileDz11Binding;
import com.gmail.androiddz.domain.entity.ProfileDomain;

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileDomain,
        ProfileItemViewModel, ItemProfileDz11Binding> {

    public ProfileItemViewHolder(ItemProfileDz11Binding binding,
                                 ProfileItemViewModel viewModel, ClickHandler clickHandler) {
        super(binding, viewModel);
        binding.setProfile(viewModel);
        binding.setHandler(clickHandler);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                       ProfileItemViewModel viewModel) {
        ItemProfileDz11Binding binding = ItemProfileDz11Binding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel, new ClickHandler(parent.getContext()));
    }
}
