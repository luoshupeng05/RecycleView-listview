package com.lsp.uidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewShow extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private MyRecycleViewAdapter mAdapter;

    private LinearLayoutManager mLinearLayoutManager;

    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_show);

        mList = new ArrayList();
        mRecyclerView = findViewById(R.id.rv_list);
        // 初始化数据
        initData(mList);
        //创建布局管理器，垂直设置LinearLayoutManager.VERTICAL，水平设置LinearLayoutManager.HORIZONTAL
        mLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
        ,false);
        //创建适配器，将数据传递给适配器
        mAdapter = new MyRecycleViewAdapter(mList);
        //设置布局管理器
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // 设置适配器
        mRecyclerView.setAdapter(mAdapter);


    }

    public void initData(List list) {
        for (int i = 1; i <= 40; i++) {
            list.add("第" + i + "条数据");
        }
    }

}