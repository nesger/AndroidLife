package com.nesger.recyclerview.dragvertical;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nesger.recyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zengyu.Zhan on 2017/11/23.
 */

public class DragVerticalRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;

    public DragVerticalRecyclerViewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
