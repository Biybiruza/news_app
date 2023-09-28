package com.biybiruza.news.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biybiruza.news.R;
import com.biybiruza.news.data.Articles;
import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolderHome> {

    private List<Articles> list;
    private OnItemClickListener onItemClickListener;

    public AdapterHome(List<Articles> list, OnItemClickListener onItemClickListener) {
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String url);
    }

    public class ViewHolderHome extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView tvCountry, tvNewsName, tvChanelName, tvTime;
        public ViewHolderHome(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_img);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvNewsName = itemView.findViewById(R.id.tv_newsName);
            tvChanelName = itemView.findViewById(R.id.tv_chanelName);
            tvTime = itemView.findViewById(R.id.tv_time);

        }
    }

    @NonNull
    @Override
    public ViewHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderHome(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHome holder, int position) {
        Articles models = list.get(position);
        if (models.getUrlToImage() != null) Glide.with(holder.itemView).load(models.getUrlToImage()).into(holder.itemImage);

      holder.tvCountry.setText(list.get(position).getAuthor());
      holder.tvNewsName.setText(list.get(position).getTitle());
      holder.tvChanelName.setText(list.get(position).getAuthor());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            Date date = format.parse(models.getPublishedAt());
            holder.tvTime.setText(date.toString());
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(models.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
