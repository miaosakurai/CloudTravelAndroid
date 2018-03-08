package com.cloudtravel.cloudtravelandroid.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.List;

public class SearchResultItemAdapter extends RecyclerView.Adapter<SearchResultItemAdapter.ViewHolder> {

    private List<SearchResultItem> mSearchResultItemList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemAddress;

        public ViewHolder(View view) {
            super(view);
            itemName=view.findViewById(R.id.item_name);
            itemAddress=view.findViewById(R.id.item_address);
        }
    }

    public SearchResultItemAdapter(List<SearchResultItem> searchResultItemList) {
        mSearchResultItemList=searchResultItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
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

