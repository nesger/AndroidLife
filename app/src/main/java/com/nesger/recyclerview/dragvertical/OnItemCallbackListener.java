package com.nesger.recyclerview.dragvertical;

/**
 * Created by GT on 2017/11/15.
 */

public interface OnItemCallbackListener {
    /**
     * @param fromPosition 起始位置
     * @param toPosition   移动的位置
     */
    void onMove(int fromPosition, int toPosition);
}
