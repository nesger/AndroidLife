package com.nesger.recyclerview.dragvertical;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nesger.recyclerview.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Zengyu.Zhan on 2017/11/23.
 */

public class DragVerticalRecyclerViewAdapter extends RecyclerView.Adapter<DragVerticalRecyclerViewViewHolder> implements OnItemCallbackListener{

    private Activity activity;
    private List<String> itemList;

    public DragVerticalRecyclerViewAdapter(Activity activity, List<String> itemList) {
        if (activity == null || itemList == null) {
            throw new IllegalArgumentException("params can't be null");
        }
        this.activity = activity;
        this.itemList = itemList;
    }

    @Override
    public DragVerticalRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new DragVerticalRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DragVerticalRecyclerViewViewHolder holder, int position) {
        holder.mTxtTitle.setText(itemList.get(position));
//        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ItemTouchHelper itemTouchHelper = ((DragVerticalRecyclerViewActivity) (activity)).getItemTouchHelper();
//                if (itemTouchHelper != null) {
//                    itemTouchHelper.startDrag(holder);
//                }
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        /**
         * 在这里进行给原数组数据的移动
         * 第一个参数为数据源
         */
        Collections.swap(itemList, fromPosition, toPosition);
        /**
         * 通知数据移动
         */
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwipeRight(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
        Toast.makeText(activity, "swipe right", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeLift(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
        Toast.makeText(activity, "swipe left", Toast.LENGTH_SHORT).show();
    }
}
