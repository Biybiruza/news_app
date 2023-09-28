package com.biybiruza.news.ui.home.search;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class AdapterViewPagerSearch extends FragmentStateAdapter {

    private List<Fragment> fragments;

    public AdapterViewPagerSearch(List<Fragment> fragments,
                                  @NonNull FragmentManager fragmentManager,
                                  @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
