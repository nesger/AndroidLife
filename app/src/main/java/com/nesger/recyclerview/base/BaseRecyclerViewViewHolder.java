package com.nesger.recyclerview.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nesger.recyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GT on 2017/11/23.
 */

public class BaseRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;

    public BaseRecyclerViewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
