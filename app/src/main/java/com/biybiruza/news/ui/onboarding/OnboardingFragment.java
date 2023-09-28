package com.biybiruza.news.ui.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biybiruza.news.R;
import com.biybiruza.news.databinding.FragmentOnboardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnboardingFragment extends Fragment {

    public OnboardingFragment() {
        super(R.layout.fragment_onboarding);
    }

    private FragmentOnboardingBinding binding;
    private ViewPagerAdapter adapter;
    private int vpCurrentIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingBinding.inflate(inflater,container,false);

        // Hide status bar
        View windowDecorView = requireActivity().getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Log.d("Tag", "onCreateView");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Tag", "onViewCreated");

        List<Integer> imgList = new ArrayList<>();
        imgList.add(R.drawable.img_1);
        imgList.add(R.drawable.img_2);
        imgList.add(R.drawable.img_3);

        adapter = new ViewPagerAdapter(imgList);
        binding.viewPager.setAdapter(adapter);
        binding.tabL.setupWithViewPager(binding.viewPager);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(++vpCurrentIndex);
                if (vpCurrentIndex == imgList.size()) {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.mainFragment);
                }
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(--vpCurrentIndex);
            }
        });

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                vpCurrentIndex = position;

                if (position == imgList.size() - 1) {
                    binding.btnNext.setText("Get Started");
                    binding.btnBack.setVisibility(View.VISIBLE);

                } else if (position == 0){
                    binding.btnNext.setText("Next");
                    binding.btnBack.setVisibility(View.GONE);
                } else {
                    binding.btnNext.setText("Next");
                    binding.btnBack.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}