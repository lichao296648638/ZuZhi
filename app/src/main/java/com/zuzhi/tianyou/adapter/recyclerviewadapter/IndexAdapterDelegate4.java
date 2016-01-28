package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.bean.IndexHome;

import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate4 extends IndexAdapterDelegate {

    public IndexAdapterDelegate4(Context context, int viewType) {
        super(context, viewType);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(mInflater.inflate(R.layout.i_index_4, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IndexHome items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {

    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
