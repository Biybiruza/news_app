package com.biybiruza.news.ui.home.search.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.biybiruza.news.R;
import com.biybiruza.news.data.Articles;
import com.biybiruza.news.data.Models;
import com.biybiruza.news.databinding.FragmentNewsBinding;
import com.biybiruza.news.networking.ApiClient;
import com.biybiruza.news.networking.ApiService;
import com.biybiruza.news.ui.home.AdapterHome;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    public NewsFragment() {
        super(R.layout.fragment_news);
    }

    private FragmentNewsBinding binding;
    private AdapterHome adapterHome;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService(apiService);
    }

    private void apiService(ApiService apiService) {
        apiService.getNewsList().enqueue(new Callback<Models>() {
            @Override
            public void onResponse(Call<Models> call, Response<Models> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapterHome = new AdapterHome(
                            response.body().getArticles(),
                            new AdapterHome.OnItemClickListener() {
                                @Override
                                public void onItemClick(String url) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("url",url);
                                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_searchFragment_to_detailsFragment, bundle);
                                }
                            });
                    RecyclerView.LayoutManager linearLayoutManager =
                            new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
                    binding.rvNews.setLayoutManager(linearLayoutManager);
                    binding.rvNews.setAdapter(adapterHome);

                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Models> call, Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }
}