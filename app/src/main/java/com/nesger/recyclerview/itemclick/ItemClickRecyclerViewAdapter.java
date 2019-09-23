package com.nesger.recyclerview.itemclick;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesger.recyclerview.R;

import java.util.List;

/**
 * Created by Zengyu.Zhan on 2017/11/23.
 */

public class ItemClickRecyclerViewAdapter extends RecyclerView.Adapter<ItemClickRecyclerViewViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<String> itemList;

    public ItemClickRecyclerViewAdapter(Activity activity, List<String> itemList) {
        if (activity == null || itemList == null) {
            throw new IllegalArgumentException("params can't be null");
        }
        this.activity = activity;
        this.itemList = itemList;
    }

    @Override
    public ItemClickRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        view.setOnClickListener(this);
        return new ItemClickRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemClickRecyclerViewViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.mTxtTitle.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
