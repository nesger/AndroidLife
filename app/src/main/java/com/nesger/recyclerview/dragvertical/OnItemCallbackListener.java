package com.nesger.recyclerview.dragvertical;

/**
 * Created by Zengyu.Zhan on 2017/11/15.
 */

public interface OnItemCallbackListener {
    /**
     * @param fromPosition 起始位置
     * @param toPosition   移动的位置
     */
    void onMove(int fromPosition, int toPosition);

    //右滑
    void onSwipeRight(int position);

    //左滑
    void onSwipeLift(int position);
}
