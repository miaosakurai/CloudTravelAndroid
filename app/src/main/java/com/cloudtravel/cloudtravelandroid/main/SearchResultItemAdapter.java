package com.cloudtravel.cloudtravelandroid.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.List;

public class SearchResultItemAdapter extends RecyclerView.Adapter<SearchResultItemAdapter.ViewHolder> {

    private List<SearchResultItem> mSearchResultItemList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView itemName;
        TextView itemAddress;

        public ViewHolder(View view) {
            super(view);
            itemView=view;
            itemName=view.findViewById(R.id.item_name);
            itemAddress=view.findViewById(R.id.item_address);
        }
    }

    public SearchResultItemAdapter(List<SearchResultItem> searchResultItemList) {
        mSearchResultItemList=searchResultItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        if (mContext==null) {
            mContext=parent.getContext();
        }
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item_layout,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                SearchResultItem searchResultItem = mSearchResultItemList.get(position);
                Intent intent = new Intent(mContext,PlaceSelectedActivity.class);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchResultItem resultItem=mSearchResultItemList.get(position);
        holder.itemAddress.setText(resultItem.getAddress());
        holder.itemName.setText(resultItem.getName());
    }

    @Override
    public int getItemCount() {
        return mSearchResultItemList.size();
    }
}

