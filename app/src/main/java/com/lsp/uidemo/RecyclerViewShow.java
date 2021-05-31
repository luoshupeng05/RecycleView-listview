package com.lsp.uidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewShow extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private MyRecycleViewAdapter mAdapter;

    /**
     * 三种不同的布局方式
     * 1、线性布局
     * 2、网格布局
     * 3、瀑布流布局
     */

    private LinearLayoutManager mLinearLayoutManager;

    private GridLayoutManager mGridLayoutManager;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_show);

        Button btnADD= findViewById(R.id.btn_add);
        Button btnRemove= findViewById(R.id.btn_remove);

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addItem();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.removeItem(0);
            }
        });

        mList = new ArrayList();
        mRecyclerView = findViewById(R.id.rv_list);
        // 初始化数据
        initData(mList);

        /**创建布局管理器，垂直设置LinearLayoutManager.VERTICAL，水平设置LinearLayoutManager.HORIZONTAL **/
        mLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
        ,false);
        //创建适配器，将数据传递给适配器
        mAdapter = new MyRecycleViewAdapter(mList);
        //设置布局管理器
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // 设置适配器
        mRecyclerView.setAdapter(mAdapter);
        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //设置动画效果
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置自定义的item监听事件
        mAdapter.setOnItemClickListener(new MyRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"第 " + position + "条数据",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initData(List list) {
        for (int i = 1; i <= 40; i++) {
            list.add("第" + i + "条数据");
        }
    }

}