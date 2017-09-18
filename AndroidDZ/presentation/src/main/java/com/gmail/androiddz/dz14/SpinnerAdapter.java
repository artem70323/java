package com.gmail.androiddz.dz14;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gmail.androiddz.R;
import com.gmail.androiddz.databinding.SpinnerDz14Binding;
import com.gmail.androiddz.domain.entity.CountryDomain;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {

    ArrayList<CountryDomain> countries;

    public SpinnerAdapter(ArrayList<CountryDomain> countries) {
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= countries.size()) return countries.get(0);
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            // create new holder
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            Dz14ItemViewModel viewModel = new Dz14ItemViewModel(countries.get(position));
//            holder = ViewHolder.create(inflater, parent, viewModel);
//            convertView = holder.dataBinding.getRoot();
//
//            convertView.setTag(holder);
//        } else {
//            // update model for old holder
//            holder = (ViewHolder) convertView.getTag();
//            holder.bind(countries.get(position));
//        }
//
//        return convertView;

        ViewHolder holder;
        Dz14ItemViewModel viewModel;
        if (convertView == null) {
            SpinnerDz14Binding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.spinner_dz14, parent, false);

            holder = new ViewHolder(itemBinding);
            holder.view = itemBinding.getRoot();
            holder.view.setTag(holder);
            viewModel = new Dz14ItemViewModel(countries.get(position));
            holder.binding.setViewModel(viewModel);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            holder.binding.getViewModel().setCountry(countries.get(position));
        }
        return holder.view;
    }

    static class ViewHolder {

//        SpinnerDz14Binding dataBinding;
//        Dz14ItemViewModel viewModel;
//
//        public ViewHolder(SpinnerDz14Binding dataBinding, Dz14ItemViewModel viewModel) {
//            this.dataBinding = dataBinding;
//            this.viewModel = viewModel;
//            dataBinding.setViewModel(viewModel);
//        }
//
//        public void bind(CountryDomain country) {
//            viewModel.setCountry(country);
//            dataBinding.executePendingBindings(); // refresh layout
//        }
//
//        public static ViewHolder create(LayoutInflater inflater, ViewGroup parent,
//                                        Dz14ItemViewModel viewModel) {
//            SpinnerDz14Binding binding = SpinnerDz14Binding.inflate(inflater, parent, false);
//            return new ViewHolder(binding, viewModel);
//        }

        private View view;
        private SpinnerDz14Binding binding;

        ViewHolder(SpinnerDz14Binding binding) {
            this.view = binding.getRoot();
            this.binding = binding;
        }
    }

}
