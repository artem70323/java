package com.artyombash.presentation.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.Competition;
import com.artyombash.presentation.ClickHandler;
import com.artyombash.presentation.base.BaseItemViewHolder;
import com.artyombash.presentation.databinding.ItemCompetitionBinding;
import com.artyombash.presentation.viewModel.CompetitionItemViewModel;

public class CompetitionItemViewHolder extends BaseItemViewHolder<Competition,
        CompetitionItemViewModel, ItemCompetitionBinding>{

    public CompetitionItemViewHolder(ItemCompetitionBinding binding,
                                     CompetitionItemViewModel viewModel, ClickHandler clickHandler) {
        super(binding, viewModel);
        binding.setCompetition(viewModel);
        binding.setHandler(clickHandler);
    }

    public static CompetitionItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                                   CompetitionItemViewModel viewModel) {
        ItemCompetitionBinding binding = ItemCompetitionBinding.inflate(inflater, parent, false);
        return new CompetitionItemViewHolder(binding, viewModel, new ClickHandler(parent.getContext()));
    }

}
