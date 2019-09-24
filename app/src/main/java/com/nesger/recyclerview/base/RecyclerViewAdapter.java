package com.nesger.recyclerview.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesger.recyclerview.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Zengyu.Zhan
 * Created on 2017/11/23.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {

    private Activity activity;
    private List<Long> itemList;
    private Set<RecyclerViewViewHolder> mHolders;
    private ScheduledExecutorService mExecutorService;

    public RecyclerViewAdapter(Activity activity, List<Long> itemList) {
        if (activity == null || itemList == null) {
            throw new IllegalArgumentException("params can't be null");
        }
        this.activity = activity;
        this.itemList = itemList;
        mHolders = new HashSet<>();
        mExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                return new Thread(r);
            }
        });
        mExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (RecyclerViewViewHolder holder : mHolders) {
                    updateTime(holder, holder.getTime());
                }
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        holder.setTime(itemList.get(position));
        mHolders.add(holder);
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
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
