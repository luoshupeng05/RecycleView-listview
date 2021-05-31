package com.lsp.uidemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private OnItemClickListener mOnItemClickListener;

    public MyRecycleViewAdapter(List list) {
        mList = list;
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


    @Override
    /**通过方法提供的ViewHolder，将数据绑定到ViewHolder中 **/
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.mTextView.setText(mList.get(position).toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, holder.getAdapterPosition() + 1);
                }
            }
        });
    }

    /**
     * 自定义的ViewHolder
     */
    class MyHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_content);

        }
    }

    /**
     * 供外部调用设置监听
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * 自定义的接口
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    /**
     * 增加两个方法用于移除，增加item
     * 1、添加数据
     */

    public void addItem() {
        mList.add(0, "我是新数据");
        // 不能用notifyDataSetChanged()，这样无动画效果
        notifyItemChanged(0);
    }

    /**
     * 增加两个方法用于移除，增加item
     * 2、删除数据
     */
    public void removeItem(int position) {
        mList.remove(position);
        notifyItemChanged(position);

    }


}
