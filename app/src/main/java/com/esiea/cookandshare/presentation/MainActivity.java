package com.esiea.cookandshare.presentation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.databinding.ActivityMainBinding;
import com.esiea.cookandshare.di.App;
import com.esiea.cookandshare.presentation.model.DataViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity
{
    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getNetComponent().injectMainActivity(this);

        View view = bind();
        initRecyclerView(view);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        dataViewModel.setUp();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        dataViewModel.tearDown();
    }

    private View bind()
    {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataViewModel = new DataViewModel();
        binding.setViewModel(dataViewModel);
        return binding.getRoot();
    }

    private void initRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
    }
}
