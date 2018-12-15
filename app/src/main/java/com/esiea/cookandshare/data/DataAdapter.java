package com.esiea.cookandshare.data;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.databinding.ItemDataBinding;
import com.esiea.cookandshare.presentation.model.DataItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>
{
    private static final String TAG = "DataAdapter";
    private List<Ingredient> data;

    public DataAdapter()
    {
        this.data = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data, new FrameLayout(viewGroup.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position)
    {
        Ingredient ingredient = data.get(position);
        holder.setViewModel(new DataItemViewModel(ingredient));
    }

    @Override
    public int getItemCount()
    {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder)
    {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder)
    {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<Ingredient> data)
    {
        if (data == null || data.isEmpty())
        {
            this.data.clear();
        }
        else
        {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder
    {
        ItemDataBinding binding;

        DataViewHolder(View itemView)
        {
            super(itemView);
            bind();
        }

        void bind()
        {
            if (binding == null)
            {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind()
        {
            if (binding != null)
            {
                binding.unbind();
            }
        }

        void setViewModel(DataItemViewModel viewModel)
        {
            if (binding != null)
            {
                binding.setViewModel(viewModel);
            }
        }
    }
}
