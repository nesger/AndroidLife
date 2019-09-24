package com.nesger.recyclerview.base;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesger.recyclerview.R;

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
        updateTime(holder, itemList.get(position));
    }

    private void updateTime(final RecyclerViewViewHolder holder, final long time) {
        String content;
        long remainTime = time - System.currentTimeMillis();
        remainTime /= 1000;
        if (remainTime <= 0) {
            content = "Time up";
            holder.mTxtTitle.setText(content);
            return;
        }

        content = "剩下"+remainTime+"秒";
        holder.mTxtTitle.setText(content);
        holder.mTxtTitle.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateTime(holder, time);
            }
        }, 1000);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
