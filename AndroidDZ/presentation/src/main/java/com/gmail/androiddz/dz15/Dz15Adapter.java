package com.gmail.androiddz.dz15;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.androiddz.databinding.ActivityDz15ListBinding;
import com.gmail.androiddz.domain.entity.ProfileDomainSql;

import java.util.ArrayList;

public class Dz15Adapter extends RecyclerView.Adapter<Dz15Adapter.ViewHolder> {

    private ArrayList<ProfileDomainSql> domainSqls = new ArrayList<>();

    public void setDomainSqls(ArrayList<ProfileDomainSql> domainSql) {
        domainSqls.clear();
        domainSqls.addAll(domainSql);
//        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ActivityDz15ListBinding itemBinding = ActivityDz15ListBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ProfilesItemViewModel itemViewModel = new ProfilesItemViewModel(domainSqls.get(position).getName());
        viewHolder.bind(itemViewModel);
    }

    @Override
    public int getItemCount() {
        Log.e("getItemCount", String.valueOf(domainSqls.size()));
        return domainSqls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ActivityDz15ListBinding binding;

        public ViewHolder(ActivityDz15ListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProfilesItemViewModel item) {
            binding.setProfile(item);
            binding.executePendingBindings();
        }
    }

}
