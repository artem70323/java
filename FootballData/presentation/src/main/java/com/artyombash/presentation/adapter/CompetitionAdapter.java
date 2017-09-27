package com.artyombash.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.artyombash.domain.entity.Competition;
import com.artyombash.presentation.base.BaseAdapter;
import com.artyombash.presentation.viewModel.CompetitionItemViewModel;

/**
 * Adaptar that manages a collection of {@link Competition}.
 */
public class CompetitionAdapter extends BaseAdapter<Competition, CompetitionItemViewModel> {

    @Override
    public CompetitionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CompetitionItemViewModel itemViewModel = new CompetitionItemViewModel();
        return CompetitionItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
