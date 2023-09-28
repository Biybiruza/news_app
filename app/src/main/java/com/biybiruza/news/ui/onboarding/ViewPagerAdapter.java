package com.biybiruza.news.ui.onboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.biybiruza.news.databinding.ItemViewPagerBinding;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private List<Integer> list;
    private ItemViewPagerBinding binding;

    public ViewPagerAdapter(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        binding = ItemViewPagerBinding.
                inflate(
                        LayoutInflater.from(container.getContext()),container, false);

        binding.ivOnboard.setImageResource(list.get(position));

        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
