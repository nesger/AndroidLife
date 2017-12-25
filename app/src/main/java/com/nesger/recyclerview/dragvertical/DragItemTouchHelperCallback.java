package com.nesger.recyclerview.dragvertical;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by GT on 2017/12/20.
 */

public class DragItemTouchHelperCallback extends ItemTouchHelper.Callback {


    private OnItemCallbackListener mOnItemCallbackListener;

    public DragItemTouchHelperCallback(OnItemCallbackListener mOnItemCallbackListener) {
        this.mOnItemCallbackListener = mOnItemCallbackListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //设置为可上下拖拽
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        /**
         * 回调
         */
        mOnItemCallbackListener.onMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

}
