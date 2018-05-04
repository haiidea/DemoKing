package com.haiidea.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView view = findViewById(R.id.body_rl);
        view.setLayoutManager(new GridLayoutManager(this, 3));
        CommonAdapter commonAdapter = new CommonAdapter();
        mDataList.add("对勾加号转换");
        view.setAdapter(commonAdapter);
    }
    private class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameTV;
        public View mConvertView;
        public int mPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mConvertView = itemView;
            mNameTV = itemView.findViewById(R.id.name_tv);
        }
        public View getConvertView() {
            return mConvertView;
        }
    }
    public  class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, parent,
                    false);
            final ViewHolder holder = new ViewHolder(itemView);
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("对勾加号转换".equals(mDataList.get(holder.mPosition))){
                        startActivity(new Intent(MainActivity.this, DouhaoActivity.class));
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.mPosition = position;
            holder.mNameTV.setText(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }
}
