package com.esiea.cookandshare.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.esiea.cookandshare.data.DataAdapter;
import com.esiea.cookandshare.data.Ingredient;

import java.util.List;

public class RecyclerViewDataBinding
{
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<Ingredient> data)
    {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
