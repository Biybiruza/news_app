package com.biybiruza.news.ui.splash;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.biybiruza.news.R;
import com.biybiruza.news.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    public SplashFragment() {
        super(R.layout.fragment_splash);
    }

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FragmentSplashBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.onboardingFragment);
            }
        }, 200);
    }

}