package com.example.chocoapi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.bumptech.glide.Glide;
import com.example.chocoapi.R;
import com.example.chocoapi.rest.entities.Deal;
import com.example.chocoapi.rest.entities.MainDeal;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealViewHolder> {

    List<Deal> dealList;
    private View view;

    public DealAdapter() {
        this.dealList = new ArrayList<>();
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList.clear();
        this.dealList.addAll(dealList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item, viewGroup, false);
        return new DealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder dealViewHolder, int position) {
        dealViewHolder.bind(dealList.get(position));
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }
}
