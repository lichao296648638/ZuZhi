package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates.AbsAdapterDelegate;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.bean.BaGongGe;
import com.zuzhi.tianyou.bean.IndexHome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate3 extends IndexAdapterDelegate {

    public IndexAdapterDelegate3(Context context, int viewType) {
        super(context, viewType);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(mInflater.inflate(R.layout.i_index_3, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IndexHome items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        bindView((ViewHolder) holder, items.getBaGongGe(position));
    }

    private void bindView(ViewHolder holder, List<BaGongGe> list) {
        for (int i = 0; i < 4; i++) {
            if (i > list.size()) {
                holder.imageViews[i].setVisibility(View.INVISIBLE);
                holder.textviews[i].setVisibility(View.INVISIBLE);
            } else {
                holder.imageViews[i].setVisibility(View.VISIBLE);
                holder.textviews[i].setVisibility(View.VISIBLE);
                BaGongGe data = list.get(i);
                ImageLoader.getInstance().displayImage(data.img, holder.imageViews[i]);
                holder.textviews[i].setText(data.text);
            }
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView[] imageViews = new ImageView[4];
        private TextView[] textviews = new TextView[4];

        public ViewHolder(View itemView) {
            super(itemView);
            int[] layoutIds = new int[]{R.id.layout1, R.id.layout2, R.id.layout3, R.id.layout4};
            for (int i = 0; i < layoutIds.length; i++) {
                View view = itemView.findViewById(layoutIds[i]);
                imageViews[i] = (ImageView) view.findViewById(R.id.iv_item_index_guide);
                textviews[i] = (TextView) view.findViewById(R.id.tv_item_index_guide);
            }
        }
    }
}
