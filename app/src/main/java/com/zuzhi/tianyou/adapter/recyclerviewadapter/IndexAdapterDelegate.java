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
import com.zuzhi.tianyou.entity.ImageEntity;
import com.zuzhi.tianyou.utils.ViewSetUtils;
import com.zuzhi.tianyou.views.AutoScrollViewPager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate extends AbsAdapterDelegate<List<Map<String, Object>>> {
    private static final int IMAGEVIEW_MAX_CACHE_LENGTH = 5;

    private Context mContext;
    private LayoutInflater mInflater;

    private LinkedList<ImageView> mImageViewCacheList = new LinkedList<>();

    public IndexAdapterDelegate(Context context, int viewType) {
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
        return new ViewHolder(mInflater.inflate(R.layout.banner, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Map<String, Object>> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        Map<String, Object> data = items.get(position);
        List<ImageEntity> list = (List<ImageEntity>) data.get("images");
        setBanner((ViewHolder) holder, list);
    }

    private void setBanner(final ViewHolder holder, List<ImageEntity> list) {
        holder.asvp_banner.setAdapter(new ImagePagerAdapter(mContext, list).setInfiniteLoop(true));
        holder.asvp_banner.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                setBannerIndex(holder.ll_pointer_banner, position);
            }
        });
        holder.asvp_banner.setInterval(5000);
        holder.asvp_banner.startAutoScroll();
        holder.asvp_banner.setCurrentItem(0);

        addPointer(holder.ll_pointer_banner, list.size());
        setBannerIndex(holder.ll_pointer_banner, 0);
    }

    private void addPointer(ViewGroup group, int size) {
        int childCount = group.getChildCount();
        if (childCount == size) {
            return;
        }
        if (childCount > size) {
            int length = childCount - size;
            for (int i = 0; i < length; i++) {
                ImageView imageView = (ImageView) group.getChildAt(i);
                recycleImageView(imageView);
            }
        } else {
            int length = size - childCount;
            for (int i = 0; i < length; i++) {
                group.addView(getImageView());
            }
        }
    }

    private void setBannerIndex(LinearLayout group, int position) {
        if (position < 0) {
            return;
        }
        int childCount = group.getChildCount();
        if (childCount > position) {
            for (int i = 0; i < childCount; i++) {
                ImageView imageView = (ImageView) group.getChildAt(i);
                if (i == position) {
                    imageView.setImageResource(R.drawable.bp_focus);
                } else {
                    imageView.setImageResource(R.drawable.bp_disable);
                }
            }
        }
    }

    private ImageView getImageView() {
        if (mImageViewCacheList.isEmpty()) {
            ImageView iv_temp = new ImageView(mContext);
            int size = ViewSetUtils.dp2px(mContext, 15);
            iv_temp.setLayoutParams(new ViewGroup.LayoutParams(size, size));
            int padding = ViewSetUtils.dp2px(mContext, 2);
            iv_temp.setPadding(padding, 0, padding, 0);
            return iv_temp;
        } else {
            return mImageViewCacheList.removeFirst();
        }
    }

    private void recycleImageView(ImageView imageView) {
        if (mImageViewCacheList.size() <= IMAGEVIEW_MAX_CACHE_LENGTH) {
            mImageViewCacheList.add(imageView);
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private AutoScrollViewPager asvp_banner;
        private LinearLayout ll_pointer_banner;

        public ViewHolder(View itemView) {
            super(itemView);
            asvp_banner = (AutoScrollViewPager) itemView.findViewById(R.id.asvp_banner);
            ll_pointer_banner = (LinearLayout) itemView.findViewById(R.id.ll_pointer_banner);
        }
    }
}