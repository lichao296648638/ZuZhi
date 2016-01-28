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
import com.zuzhi.tianyou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanglw on 2016-1-28.
 */
public class IndexAdapterDelegate3 extends AbsAdapterDelegate<List<Map<String, Object>>> {
    private LayoutInflater mInflater;

    public IndexAdapterDelegate3(Context context, int viewType) {
        super(viewType);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Map<String, Object>> items, int position) {
        return getItemViewType() == (Integer)items.get(position).get("viewType");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(mInflater.inflate(R.layout.i_index_3, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Map<String, Object>> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        Map<String, Object> map = items.get(position);
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) map.get("data");
        bindView((ViewHolder) holder, list);
    }

    private void bindView(ViewHolder holder, ArrayList<HashMap<String, Object>> list) {
        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> data = list.get(i);
            String text = (String) data.get("string");
            Drawable drawable = (Drawable) data.get("image");
            holder.imageViews[i].setImageDrawable(drawable);
            holder.textviews[i].setText(text);
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
