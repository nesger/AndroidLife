package com.nesger.recyclerview.itemclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.nesger.recyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemClickecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private ItemClickRecyclerViewAdapter mAdapter;
    private List<String> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initRecyclerView();
    }

    /**
     * 获取数据源
     */
    private void initData() {
        String[] itemList = getResources().getStringArray(R.array.item_list);
        mItemList.addAll(Arrays.asList(itemList));
    }


    private void initRecyclerView() {
        //设置子视图
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //设置适配器
        mAdapter = new ItemClickRecyclerViewAdapter(this, mItemList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ItemClickRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ItemClickecyclerViewActivity.this,"click position="+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
