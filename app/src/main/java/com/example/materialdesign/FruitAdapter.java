package com.example.materialdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.infoHolder> {

    private ArrayList<String> mContentList;
    private Context mContext;

    public FruitAdapter(ArrayList<String> mContentList, Context mContext) {
        this.mContentList = mContentList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FruitAdapter.infoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_fruit_item, parent, false);
        return new infoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.infoHolder holder, int position) {
        String s = mContentList.get(position);
        holder.contentTv.setText(s);
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }


    public class infoHolder extends RecyclerView.ViewHolder {
        private TextView contentTv;

        public infoHolder(@NonNull View itemView) {
            super(itemView);

            contentTv = itemView.findViewById(R.id.tv_content);
        }
    }
}
