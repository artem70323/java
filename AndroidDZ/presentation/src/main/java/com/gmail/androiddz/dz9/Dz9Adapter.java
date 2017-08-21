package com.gmail.androiddz.dz9;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.androiddz.databinding.ItemDz9Binding;

public class Dz9Adapter extends RecyclerView.Adapter<Dz9Adapter.ViewHolder> {

    private String[] androidImageUrls;

    public Dz9Adapter(String[] androidImageUrls) {
        this.androidImageUrls = androidImageUrls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemDz9Binding itemBinding = ItemDz9Binding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ItemViewModel itemViewModel = new ItemViewModel(androidImageUrls[position]);
        viewHolder.bind(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return androidImageUrls.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemDz9Binding binding;

        public ViewHolder(ItemDz9Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ItemViewModel item) {
            binding.setViewModel(item);
            binding.executePendingBindings();
        }
    }

}
