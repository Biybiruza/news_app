package com.biybiruza.news.ui.home.search.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.biybiruza.news.R;
import com.biybiruza.news.data.Authors;

import java.util.List;

public class AdapterAuthors extends RecyclerView.Adapter<AdapterAuthors.ViewHolderAuthors> {

    private List<Authors> list;

    public AdapterAuthors(List<Authors> list) {
        this.list = list;
    }

    public interface OnClickSaveButton {
        void onClickSave(int position);
    }

    public class ViewHolderAuthors extends RecyclerView.ViewHolder {

        ImageView authorImage;
        TextView tvAuthorName, tvFollowCount;
        AppCompatButton btnFollow;
        public ViewHolderAuthors(@NonNull View itemView) {
            super(itemView);

            authorImage = itemView.findViewById(R.id.iv_author);
            tvAuthorName = itemView.findViewById(R.id.tv_authorName);
            tvFollowCount = itemView.findViewById(R.id.tv_followCount);
            btnFollow = itemView.findViewById(R.id.btn_follow);


        }
    }

    @NonNull
    @Override
    public ViewHolderAuthors onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAuthors(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_authors, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuthors holder, @SuppressLint("RecyclerView") int position) {
      holder.authorImage.setImageResource(list.get(position).getImage());
      holder.tvAuthorName.setText(list.get(position).getName());
      holder.tvFollowCount.setText(list.get(position).getFollowCount());

        boolean condition = list.get(position).isFollow();

        if (list.get(position).isFollow()){
            holder.btnFollow.setText("Following");
            holder.btnFollow.setTextColor(Color.WHITE);
            holder.btnFollow.setBackgroundResource(R.drawable.shape_btn_background);
        } else {
            holder.btnFollow.setText("Follow");
            holder.btnFollow.setTextColor(Color.parseColor("#1877F2"));
            holder.btnFollow.setBackgroundResource(R.drawable.shape_btn_background_save);
        }

      holder.btnFollow.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("ResourceAsColor")
          @Override
          public void onClick(View view) {
              boolean condition = list.get(position).isFollow();
              list.get(position).setFollow(!condition);

              if (list.get(position).isFollow()){
                  holder.btnFollow.setText("Following");
                  holder.btnFollow.setTextColor(Color.WHITE);
                  holder.btnFollow.setBackgroundResource(R.drawable.shape_btn_background);
              } else {
                  holder.btnFollow.setText("Follow");
                  holder.btnFollow.setTextColor(Color.parseColor("#1877F2"));
                  holder.btnFollow.setBackgroundResource(R.drawable.shape_btn_background_save);
              }
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
