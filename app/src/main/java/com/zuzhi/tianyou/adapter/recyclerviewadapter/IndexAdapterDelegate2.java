package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.zuzhi.tianyou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate2 extends AbsAdapterDelegate<List<Map<String, Object>>> {
    private Context mContext;
    private LayoutInflater mInflater;

    public IndexAdapterDelegate2(Context context, int viewType) {
        super(viewType);
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Map<String, Object>> items, int position) {
        return getItemViewType() == (Integer)items.get(position).get("viewType");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(mInflater.inflate(R.layout.i_index_2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Map<String, Object>> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        Map<String, Object> data = items.get(position);
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) data.get("texts");
        bindView((ViewHolder) holder, list);
    }

    private void bindView(ViewHolder holder, ArrayList<HashMap<String, Object>> list) {
        NearlyVisitAdapter adp_nearlyVisit = new NearlyVisitAdapter(mContext, list);
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
