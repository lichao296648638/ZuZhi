package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.bean.AccessHistory;
import com.zuzhi.tianyou.bean.IndexHome;

import java.util.List;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate2 extends IndexAdapterDelegate {

    public IndexAdapterDelegate2(Context context, int viewType) {
        super(context, viewType);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(inflate(R.layout.i_index_2, parent));
    }

    @Override
    public void onBindViewHolder(@NonNull IndexHome items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        bindView((ViewHolder) holder, items.accessHistoryList);
    }

    private void bindView(ViewHolder holder, List<AccessHistory> list) {
        NearlyVisitAdapter2 adp_nearlyVisit = new NearlyVisitAdapter2(mContext, list);
        holder.rv_nearly_visit.setAdapter(adp_nearlyVisit);
        holder.rv_nearly_visit.setLayoutManager(new LinearLayoutManager(mContext, OrientationHelper.HORIZONTAL, false));
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv_nearly_visit;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_nearly_visit = (RecyclerView) itemView.findViewById(R.id.rv_nearly_visit);
        }
    }
}
