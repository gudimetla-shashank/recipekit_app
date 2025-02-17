package com.example.recipe.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recipe.databinding.PopularItemsBinding;

import java.util.List;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private List<String> items;  // Replace String with your actual data type

    public PopularAdapter(List<String> items) {
        this.items = items;
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {

        private final PopularItemsBinding binding;

        public PopularViewHolder(PopularItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

