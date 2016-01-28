package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
public class IndexAdapterDelegate6 extends IndexAdapterDelegate5{

    public IndexAdapterDelegate6(Context context, int viewType) {
        super(context,viewType);
    }

    @Override
    protected int getViewPagerItemContentResId(int position) {
        return R.layout.i_index_5_item_2;
    }
}
