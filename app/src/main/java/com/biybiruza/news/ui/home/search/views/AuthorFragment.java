package com.biybiruza.news.ui.home.search.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biybiruza.news.AuthorsShared;
import com.biybiruza.news.data.Authors;
import com.biybiruza.news.databinding.FragmentAuthorBinding;
import com.biybiruza.news.ui.home.search.adapter.AdapterAuthors;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AuthorFragment extends Fragment {

    private FragmentAuthorBinding binding;
    private AuthorsShared myShared;
    List<Authors> list = new ArrayList<>();

    public AuthorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAuthorBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myShared = new AuthorsShared(requireActivity(), new Gson());

        loadList();

        AdapterAuthors adapterAuthors = new AdapterAuthors(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                requireActivity(), LinearLayoutManager.VERTICAL, false);
        binding.rvAuthors.setLayoutManager(layoutManager);
        binding.rvAuthors.setAdapter(adapterAuthors);
    }

    private void loadList(){
        if (myShared.getList("authors", Authors.class) == null){
            list = Authors.authorsList();
        } else {
            list = myShared.getList("authors",Authors.class);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        myShared.putList("authors", list);

    }
}