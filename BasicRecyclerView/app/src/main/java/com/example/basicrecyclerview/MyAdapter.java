package com.example.basicrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //in order to create a RecyclerView Adapter, you need to ensure the following are implemented -
    // 1. ViewHolder class has been created (at the bottom of this class)
    // 2. OnCreateViewHolder (this makes the adapter create views as and when required)
    // 3. OnBindViewHolder (this makes the adapter bind the views to the data)
    // 4. getItemCount()    (this is also required)

    private Context mContext;
    private ArrayList<String> mArrayList;

    public MyAdapter(Context context, ArrayList<String> arrayList) {
        mContext = context;
        mArrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final String item = mArrayList.get(position);
        holder.getTextView().setText(item);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView = null;
        ImageView imageView = null;
        View v;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView =itemView.findViewById(R.id.textView);

            v = itemView;
        }
        public TextView getTextView() {
            return textView;
        }
    }

}
