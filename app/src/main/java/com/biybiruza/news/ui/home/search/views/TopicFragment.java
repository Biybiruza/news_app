package com.biybiruza.news.ui.home.search.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.lights.LightsManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.biybiruza.news.MyShared;
import com.biybiruza.news.R;
import com.biybiruza.news.data.Topics;
import com.biybiruza.news.databinding.FragmentTopicBinding;
import com.biybiruza.news.ui.home.search.adapter.AdapterTopics;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends Fragment {

    private FragmentTopicBinding binding;
    private MyShared myShared;
    List<Topics> list = new ArrayList<>();

    public TopicFragment() {
        super(R.layout.fragment_topic);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTopicBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myShared = new MyShared(requireActivity(), new Gson());

        loadList();

        AdapterTopics adapterTopics = new AdapterTopics(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false);

        binding.rvTopics.setLayoutManager(layoutManager);
        binding.rvTopics.setAdapter(adapterTopics);
    }

    private void loadList(){
        if (myShared.getList("topics",Topics.class) == null){
            list = Topics.topicsList();
        } else {
            list = myShared.getList("topics",Topics.class);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        myShared.putList("topics", list);

    }
}