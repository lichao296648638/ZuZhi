package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.zuzhi.tianyou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate5 extends AbsAdapterDelegate<List<Map<String, Object>>> {
    protected Context mContext;
    protected LayoutInflater mInflater;

    public IndexAdapterDelegate5(Context context, int viewType) {
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
        return new ViewHolder(mInflater.inflate(R.layout.i_index_5, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Map<String, Object>> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        Map<String, Object> data = items.get(position);
        String title = (String) data.get("title");
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) data.get("data");
        bindView((ViewHolder) holder,position,title, list);
    }

    private void bindView(ViewHolder holder, int position, String title, ArrayList<HashMap<String, Object>> list) {
        holder.titleTextView.setText(title);
        holder.viewPager.setAdapter(getPagerAdapter(list,position));
    }

    protected PagerAdapter getPagerAdapter(ArrayList<HashMap<String, Object>> list,int position) {
        return new IndexTopicAdapter(mInflater, list, getViewPagerItemContentResId(position));
    }

    protected int getViewPagerItemContentResId(int position) {
        if (position % 2 == 0) {
            return R.layout.i_index_5_item_1;
        } else {
            return R.layout.i_index_5_item_2;
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.vp_item_index_topic);
            titleTextView = (TextView) itemView.findViewById(R.id.tv_item_index_topic);
        }
    }

    public class IndexTopicAdapter extends PagerAdapter {
        private static final int VIEW_MAX_CACHE_LENGTH = 5;

        /**
         * viewgroup source 容器源
         */
        private LinkedList<View> mViews = new LinkedList<>();
        private ArrayList<HashMap<String, Object>> mList;
        private LayoutInflater mInflater;
        private int mLayoutId;

        public IndexTopicAdapter(LayoutInflater inflater, ArrayList<HashMap<String, Object>> list, int layoutId) {
            this.mInflater = inflater;
            this.mList = list;
            this.mLayoutId = layoutId;
        }

        //viewpager中的组件数量
        @Override
        public int getCount() {
            int size = mList.size();
            int count = size / 3;
            if (size % 3 != 0) {
                count++;
            }
            return count;
        }

        //滑动切换的时候销毁当前的组件
        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            View view = (View) object;
            container.removeView(view);
            if (mViews.size() < VIEW_MAX_CACHE_LENGTH) {
                mViews.add(view);
            }
        }

        //每次滑动的时候生成的组件
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view;
            ViewPagerHolder holder;
            if (mViews.isEmpty()) {
                view = mInflater.inflate(mLayoutId, container, false);
                holder = new ViewPagerHolder(view);
                view.setTag(holder);
            } else {
                view = mViews.removeFirst();
                holder = (ViewPagerHolder) view.getTag();
            }

            int data1Position = position * 3;
            int size = mList.size();

            for (int i = 0; i < 3; i++) {
                if (data1Position + i < size) {
                    holder.imageViews[i].setVisibility(View.VISIBLE);
                    holder.title1TextView[i].setVisibility(View.VISIBLE);
                    holder.title2TextView[i].setVisibility(View.VISIBLE);

                    HashMap<String, Object> data = mList.get(data1Position + i);
                    String title1 = (String) data.get("title1");
                    String title2 = (String) data.get("title2");
                    Drawable drawable = (Drawable) data.get("drawable");
                    holder.imageViews[i].setImageDrawable(drawable);
                    holder.title1TextView[i].setText(title1);
                    holder.title2TextView[i].setText(title2);
                } else {
                    holder.imageViews[i].setVisibility(View.INVISIBLE);
                    holder.title1TextView[i].setVisibility(View.INVISIBLE);
                    holder.title2TextView[i].setVisibility(View.INVISIBLE);
                }
            }
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }

    protected static class ViewPagerHolder {
        ImageView[] imageViews = new ImageView[3];
        TextView[] title1TextView = new TextView[3];
        TextView[] title2TextView = new TextView[3];

        public ViewPagerHolder(View view) {
            int[] layoutIds = new int[]{R.id.layout1, R.id.layout2, R.id.layout3};
            for (int i = 0; i < layoutIds.length; i++) {
                View layoutView = view.findViewById(layoutIds[i]);
                imageViews[i] = (ImageView) layoutView.findViewById(R.id.img);
                title1TextView[i] = (TextView) layoutView.findViewById(R.id.title1);
                title2TextView[i] = (TextView) layoutView.findViewById(R.id.title2);
            }
        }
    }
}
