package com.biybiruza.news.ui.home.search.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.biybiruza.news.R;
import com.biybiruza.news.data.Topics;

import java.util.List;

public class AdapterTopics extends RecyclerView.Adapter<AdapterTopics.ViewHolderTopics> {

    private List<Topics> list;
    private  OnClickSaveButton onClickListener;

    public AdapterTopics(List<Topics> list) {
        this.list = list;
    }

    public interface OnClickSaveButton {
        void onClickSave(int position);
    }

    public class ViewHolderTopics extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView tvCategory, tvNewsName;
        AppCompatButton btnSave;
        public ViewHolderTopics(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_img);
            tvCategory = itemView.findViewById(R.id.tv_country);
            tvNewsName = itemView.findViewById(R.id.tv_newsName);
            btnSave = itemView.findViewById(R.id.btn_save);


        }
    }

    @NonNull
    @Override
    public ViewHolderTopics onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderTopics(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topics, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTopics holder, @SuppressLint("RecyclerView") int position) {
      holder.itemImage.setImageResource(list.get(position).getImg());
      holder.tvCategory.setText(list.get(position).getCategory());
      holder.tvNewsName.setText(list.get(position).getNewsName());

        if (list.get(position).getSaved()){
            holder.btnSave.setText("Saved");
            holder.btnSave.setTextColor(Color.WHITE);
            holder.btnSave.setBackgroundResource(R.drawable.shape_btn_background);
        } else {
            holder.btnSave.setText("Save");
            holder.btnSave.setTextColor(Color.BLUE);
            holder.btnSave.setBackgroundResource(R.drawable.shape_btn_background_save);
        }

      holder.btnSave.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("ResourceAsColor")
          @Override
          public void onClick(View view) {
              boolean condition = list.get(position).getSaved();
              list.get(position).setSaved(!condition);

              if (list.get(position).getSaved()){
                  holder.btnSave.setText("Saved");
                  holder.btnSave.setTextColor(Color.WHITE);
                  holder.btnSave.setBackgroundResource(R.drawable.shape_btn_background);
              } else {
                  holder.btnSave.setText("Save");
                  holder.btnSave.setTextColor(Color.BLUE);
                  holder.btnSave.setBackgroundResource(R.drawable.shape_btn_background_save);
              }

          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
