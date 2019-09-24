package com.nesger.recyclerview.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nesger.recyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Zengyu.Zhan
 * Created on 2017/11/23.
 */

public class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;
    @BindView(R.id.tv_num)
    TextView mTvNum;

    public RecyclerViewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecyclerViewViewHolder holder = (RecyclerViewViewHolder) o;

        if (mTxtTitle != null ? !mTxtTitle.equals(holder.mTxtTitle) : holder.mTxtTitle != null)
            return false;
        return mTvNum != null ? mTvNum.equals(holder.mTvNum) : holder.mTvNum == null;
    }

    @Override
    public int hashCode() {
        int result = mTxtTitle != null ? mTxtTitle.hashCode() : 0;
        result = 31 * result + (mTvNum != null ? mTvNum.hashCode() : 0);
        return result;
    }
}
