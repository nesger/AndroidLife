package com.nesger.recyclerview.base;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesger.recyclerview.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Zengyu.Zhan
 * Created on 2017/11/23.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {

    private Activity activity;
    private List<Long> itemList;

    public RecyclerViewAdapter(Activity activity, List<Long> itemList) {
        if (activity == null || itemList == null) {
            throw new IllegalArgumentException("params can't be null");
        }
        this.activity = activity;
        this.itemList = itemList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.mTvNum.setText(String.valueOf(position + 1));
        holder.mTxtTitle.setText(formatDate(itemList.get(position)));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public static  String formatDate(long dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(dateTime));
    }
}
