package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.bean.AccessHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * adpater of nearly visit recyclerview 最近访问适配器
 */
public class NearlyVisitAdapter2 extends RecyclerView.Adapter<NearlyVisitAdapter2.MyViewHolder> {
    private List<AccessHistory> mData;
    private Context mContext;
    private OnItemClickLitener mOnItemClickLitener;

    /**
     * init 初始化适配器，载入数据源
     *
     * @param context
     *         上下文
     * @param data
     *         数据源
     */
    public NearlyVisitAdapter2(Context context, List<AccessHistory> data) {
        mData = data;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext)
                                              .inflate(R.layout.item_recyclerview_nearly_visit,
                                                       parent,
                                                       false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        AccessHistory history = mData.get(position);

        holder.tv_nearly_visit.setText(history.text);

        if (mOnItemClickLitener != null) {

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    class MyViewHolder extends ViewHolder {
        /**
         * text of nearly visit 最近访问文本
         */
        TextView tv_nearly_visit;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_nearly_visit = (TextView) itemView.findViewById(R.id.tv_item_nearly_visit);
        }
    }
}
