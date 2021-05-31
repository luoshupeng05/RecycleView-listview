package com.lsp.uidemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lsp.
 * Date: 2021-5-31
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyHolder> {

    private List mList;

    public MyRecycleViewAdapter(List list) {
        mList = list;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_content);

        }
    }

    /**
     * 创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
     */
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent
            , int viewType) {
        //将我们自定义的item布局R.layout.list_item转换为View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item
                , parent, false);

        //将view传递给我们自定义的ViewHolder
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 自定义的ViewHolder
     */

    @Override
    /**通过方法提供的ViewHolder，将数据绑定到ViewHolder中 **/
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).toString());
    }

}
