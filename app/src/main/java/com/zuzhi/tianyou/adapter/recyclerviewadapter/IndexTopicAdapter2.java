package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AdapterDelegatesManager;
import com.zuzhi.tianyou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * adpater of index topic recyclerview 首页推荐列表适配器
 */
public class IndexTopicAdapter2 extends RecyclerView.Adapter {
    private AdapterDelegatesManager<List<Map<String, Object>>> delegatesManager;
    private List<Map<String, Object>> items;

    public IndexTopicAdapter2(Context context, List<Map<String, Object>> items) {
        this.items = items;

        // Delegates
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new IndexAdapterDelegate(context, 0));
        delegatesManager.addDelegate(new IndexAdapterDelegate2(context, 1));
        delegatesManager.addDelegate(new IndexAdapterDelegate3(context, 2));
        delegatesManager.addDelegate(new IndexAdapterDelegate4(context, 3));
        delegatesManager.addDelegate(new IndexAdapterDelegate5(context, 4));
        delegatesManager.addDelegate(new IndexAdapterDelegate6(context, 5));
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
