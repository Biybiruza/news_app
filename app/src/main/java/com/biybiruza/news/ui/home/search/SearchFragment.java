package com.biybiruza.news.ui.home.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biybiruza.news.R;
import com.biybiruza.news.databinding.FragmentSearchBinding;
import com.biybiruza.news.ui.home.search.views.AuthorFragment;
import com.biybiruza.news.ui.home.search.views.NewsFragment;
import com.biybiruza.news.ui.home.search.views.TopicFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    List<Fragment> fragmentList;
    private AdapterViewPagerSearch adapter;

    public SearchFragment() {
        super(R.layout.fragment_search);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new NewsFragment());
        fragmentList.add(new TopicFragment());
        fragmentList.add(new AuthorFragment());

        adapter = new AdapterViewPagerSearch(fragmentList,
                getChildFragmentManager(),
                getLifecycle());

        binding.vpFragments.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.vpFragments, (tab, position) -> {
            switch (position){
                case 0: {
                    tab.setText("News");
                    return;
                }
                case 1: {
                    tab.setText("Topics");
                    return;
                }
                case 2: {
                    tab.setText("Authors");
                    return;
                }
                default: {

                }
            }

        }).attach();

    }
}