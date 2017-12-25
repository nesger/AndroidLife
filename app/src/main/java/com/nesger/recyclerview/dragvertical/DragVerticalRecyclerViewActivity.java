package com.nesger.recyclerview.dragvertical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.nesger.recyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DragVerticalRecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private DragVerticalRecyclerViewAdapter mAdapter;
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

    private ItemTouchHelper mItemTouchHelper;
    private void initRecyclerView() {
        //设置子视图
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //设置适配器
        mAdapter = new DragVerticalRecyclerViewAdapter(this, mItemList);
        mRecyclerView.setAdapter(mAdapter);


        //先实例化Callback
        ItemTouchHelper.Callback callback = new DragItemTouchHelperCallback(mAdapter);
        //用Callback构造ItemtouchHelper
        mItemTouchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

}
