package com.zuzhi.tianyou.adapter.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zuzhi.tianyou.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Administrator on 2016/1/23.
 */
public class ClassLevelOneAdapter extends BaseAdapter {
//    public static final int TYPE_CHECKED = 0;
//    public static final int TYPE_UNCHECKED = 1;
    /**
     * data of class category 服务类目数据源
     */
    private ArrayList<HashMap<String, Object>> mData;
    //index of selected item 所选项下标
    private int mPosition;
    private LayoutInflater mInflater;
    ViewHolder holder;
    Context mContext;

    /**
     * constructor of class level one 一级服务类目构造器
     *
     * @param data    数据源
     * @param context 上下文
     */
    public ClassLevelOneAdapter(ArrayList<HashMap<String, Object>> data, Context context) {
        mData = data;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf((String) mData.get(position).get("level_one_id"));
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_listview_class_level_one, null);

            holder.v_line_bottom = convertView.findViewById(R.id.v_item_class_level_one_lien_bottom);
            holder.v_line_right = convertView.findViewById(R.id.v_item_class_level_one_lien_right);
            holder.v_line_left = convertView.findViewById(R.id.v_item_class_level_one_lien_left);
            holder.tv_class_level_one = (TextView) convertView.findViewById(R.id.tv_item_class_level_one);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_class_level_one.setText((String) mData.get(position).get("level_one"));
        setSelectionView(convertView, mPosition == position);
        return convertView;
    }

    public void setSelection(int position) {
        mPosition = position;
    }

    public void setSelectionView(View view, boolean check) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder != null) {
            if (check) {
                //checked 选中样式
                holder.v_line_right.setVisibility(View.GONE);
                holder.v_line_left.setVisibility(View.VISIBLE);
                holder.tv_class_level_one.setTextColor(mContext.getResources().getColor(R.color.color_bg_button_main_normal));
                holder.tv_class_level_one.setBackgroundResource(R.color.color_bg_identifying_code_disable);
            } else {
                //unchecked 未选中样式
                holder.v_line_right.setVisibility(View.VISIBLE);
                holder.v_line_left.setVisibility(View.GONE);
                holder.tv_class_level_one.setBackgroundResource(R.color.color_white);
                holder.tv_class_level_one.setTextColor(mContext.getResources().getColor(R.color.color_normal_text));
            }
        }
    }

    public int getSelection() {
        return mPosition;
    }

    class ViewHolder {
        TextView tv_class_level_one;
        View v_line_left, v_line_right, v_line_bottom;
    }


}
