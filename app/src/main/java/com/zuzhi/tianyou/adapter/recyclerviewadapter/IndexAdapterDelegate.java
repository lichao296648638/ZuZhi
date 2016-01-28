package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.adapter.ImagePagerAdapter;
import com.zuzhi.tianyou.bean.IndexHome;
import com.zuzhi.tianyou.entity.ImageEntity;
import com.zuzhi.tianyou.utils.ViewSetUtils;
import com.zuzhi.tianyou.views.AutoScrollViewPager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public abstract class IndexAdapterDelegate extends AbsAdapterDelegate<IndexHome> {
    protected Context mContext;
    protected LayoutInflater mInflater;

    public IndexAdapterDelegate(Context context, int viewType) {
        super(viewType);
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }



    @Override
    public boolean isForViewType(@NonNull IndexHome indexHome, int position) {
        int type = indexHome.getViewTypeByPosition(position);
        Log.i("aaa","type = " + type);
        return getItemViewType() == type;
    }

    protected View inflate(int layoutId, ViewGroup parent) {
        return mInflater.inflate(layoutId, parent, false);
    }
}
