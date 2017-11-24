package com.nesger.androidlife.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nesger.androidlife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GT on 2017/11/23.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
