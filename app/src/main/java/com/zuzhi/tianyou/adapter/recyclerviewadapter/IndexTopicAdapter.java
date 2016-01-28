package com.zuzhi.tianyou.adapter.recyclerviewadapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.utils.ViewSetUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * adpater of index topic recyclerview 首页推荐列表适配器
 */
public class IndexTopicAdapter extends RecyclerView.Adapter<IndexTopicAdapter.MyViewHolder> {
    private ArrayList<HashMap<String, Object>> mData;
    private Context mContext;
    private OnItemClickLitener mOnItemClickLitener;

    /**
     * orientation type 水平模式
     */
    private final int TYPE_ORIENTATION = 0;

    /**
     * relative type 相对模式
     */
    private final int TYPE_RELATIVE = 1;


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    /**
     * init 初始化适配器，载入数据源
     *
     * @param context 上下文
     * @param data    数据源
     */
    public IndexTopicAdapter(Context context, ArrayList<HashMap<String, Object>> data) {
        mData = data;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_ORIENTATION;
        } else {
            return TYPE_RELATIVE;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_index_topic, parent, false));

        return holder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //set topic text  设置推荐类别
        holder.tv_topic.setText((String) mData.get(position).get("topic"));

        int length = ((String[]) mData.get(position).get("arr_title")).length;
        holder.initOrientatonViewPagerViews();
        holder.initRelativeViewPagerVies();
        for (int i = 0; i < length; i++) {

            if (getItemViewType(position) == TYPE_ORIENTATION) {

                if((i + 1) % 3 == 1){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_orientation1.setText(((String[]) mData.get(position).get("arr_title"))[i]);

                    //set topic info  设置推荐描述
                    holder.tv_info_orientation1.setText(((String[]) mData.get(position).get("arr_info"))[i]);

                    //set topic info  设置推荐图片
                    holder.iv_img_orientation1.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);
                }

                if((i + 1) % 3 == 2){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_orientation2.setText(((String[]) mData.get(position).get("arr_title"))[i]);
                    //set topic info  设置推荐描述
                    holder.tv_info_orientation2.setText(((String[]) mData.get(position).get("arr_info"))[i]);
                    //set topic info  设置推荐图片
                    holder.iv_img_orientation2.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);
                }
                if((i + 1) % 3 == 0){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_orientation3.setText(((String[]) mData.get(position).get("arr_title"))[i]);
                    //set topic info  设置推荐描述
                    holder.tv_info_orientation3.setText(((String[]) mData.get(position).get("arr_info"))[i]);
                    //set topic info  设置推荐图片
                    holder.iv_img_orientation3.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);
                    holder.vp_data.addView(holder.ll_view);
                    holder.list_Views.add(holder.ll_view);

                }
//                    //left one view view余1处理
//                    if (j > length / 3 * 3 && length % 3 == 1) {
//                        holder.ll_layout_orientation2.setVisibility(View.GONE);
//                        holder.ll_layout_orientation3.setVisibility(View.GONE);
//
//                        holder.params.width = holder.i_widthOrientation1;
//                        holder.ll_layout_orientation1.setLayoutParams(holder.params);
//                    }
//                    //left two view view余2处理
//                    if (j > length / 3 * 3 && length % 3 == 2) {
//                        holder.ll_layout_orientation3.setVisibility(View.GONE);
//
//                        holder.params.width = holder.i_widthOrientation1;
//                        holder.ll_layout_orientation1.setLayoutParams(holder.params);
//                        holder.ll_layout_orientation2.setLayoutParams(holder.params);
//                    }
//                if ((i + 1) % 3 == 0 && i + 1 >= 3) {
//
//                }


            } else if (getItemViewType(position) == TYPE_RELATIVE) {

                if((i + 1) % 3 == 1){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_relative1.setText(((String[]) mData.get(position).get("arr_title"))[i]);
                    //set topic info  设置推荐描述
                    holder.tv_info_relative1.setText(((String[]) mData.get(position).get("arr_info"))[i]);
                    //set topic info  设置推荐图片
                    holder.iv_img_relative1.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);
                }

                if((i + 1) % 3 == 2){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_relative2.setText(((String[]) mData.get(position).get("arr_title"))[i]);
                    //set topic info  设置推荐描述
                    holder.tv_info_relative2.setText(((String[]) mData.get(position).get("arr_info"))[i]);
                    //set topic info  设置推荐图片
                    holder.iv_img_relative2.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);
                }
                if((i + 1) % 3 == 0){
                    String test = ((String[]) mData.get(position).get("arr_title"))[i];
                    String test1 = ((String[]) mData.get(position).get("arr_info"))[i];
                    Drawable test2 = ((Drawable[]) mData.get(position).get("arr_img"))[i];

                    //set topic title  设置推荐标题
                    holder.tv_title_relative3.setText(((String[]) mData.get(position).get("arr_title"))[i]);
                    //set topic info  设置推荐描述
                    holder.tv_info_relative3.setText(((String[]) mData.get(position).get("arr_info"))[i]);
                    //set topic info  设置推荐图片
                    holder.iv_img_relative3.setBackgroundDrawable(((Drawable[]) mData.get(position).get("arr_img"))[i]);

                    holder.vp_data.addView(holder.ll_view);
                    holder.list_Views.add(holder.ll_view);
                    holder.vp_data.setAdapter(new com.zuzhi.tianyou.adapter.viewpageradapter.IndexTopicAdapter(holder.list_Views));

                }
//                    //left one view view余1处理
//                    if (j > length / 3 * 3 && length % 3 == 1) {
//                        holder.rl_layout_relative2.setVisibility(View.GONE);
//                        holder.rl_layout_relative3.setVisibility(View.GONE);
//
//                        holder.params.width = holder.i_widthOrientation1;
//                        holder.ll_layout_relative1.setLayoutParams(holder.params);
//                    }
//
//                    //left two view view余2处理
//                    if (j > length / 3 * 3 && length % 3 == 2) {
//                        holder.rl_layout_relative3.setVisibility(View.GONE);
//
//                        holder.params.width = holder.i_widthOrientation1;
//                        holder.ll_layout_relative1.setLayoutParams(holder.params);
//                        holder.params.width = (int) ViewSetUtils.px2dp(mContext, 150);
//                        holder.rl_layout_relative2.setLayoutParams(holder.params);
//                    }


            }
            holder.vp_data.setAdapter(new com.zuzhi.tianyou.adapter.viewpageradapter.IndexTopicAdapter(holder.list_Views));
        }


        if (mOnItemClickLitener != null)

        {


        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends ViewHolder {
        /**
         * data viewpager 数据页卡
         */
        ViewPager vp_data;

        /**
         * text of topic 推荐名称
         */
        TextView tv_topic;

        /**
         * view of viewpager 数据页卡view
         */
        LinearLayout ll_view;

        /**
         * orientation1 data title 水平数据1——标题
         */
        TextView tv_title_orientation1;

        /**
         * orientation1 data info 水平数据1——描述
         */
        TextView tv_info_orientation1;

        /**
         * orientation1 data img 水平数据1——图片
         */
        ImageView iv_img_orientation1;

        /**
         * orientation2 data title 水平数据2——标题
         */
        TextView tv_title_orientation2;

        /**
         * orientation2 data info 水平数据2——描述
         */
        TextView tv_info_orientation2;

        /**
         * orientation2 data img 水平数据2——图片
         */
        ImageView iv_img_orientation2;

        /**
         * orientation3 data title 水平数据3——标题
         */
        TextView tv_title_orientation3;

        /**
         * orientation3 data info 水平数据3——描述
         */
        TextView tv_info_orientation3;

        /**
         * orientation3 data img 水平数据3——图片
         */
        ImageView iv_img_orientation3;

        /**
         * relative1 data title 相对数据1——标题
         */
        TextView tv_title_relative1;

        /**
         * relative1 data info 相对数据1——描述
         */
        TextView tv_info_relative1;

        /**
         * relative1 data img 相对数据1——图片
         */
        ImageView iv_img_relative1;

        /**
         * relative2 data title 相对数据2——标题
         */
        TextView tv_title_relative2;

        /**
         * relative2 data info 相对数据2——描述
         */
        TextView tv_info_relative2;

        /**
         * relative2 data img 相对数据2——图片
         */
        ImageView iv_img_relative2;

        /**
         * relative3 data title 相对数据3——标题
         */
        TextView tv_title_relative3;

        /**
         * relative3 data info 相对数据1——描述
         */
        TextView tv_info_relative3;

        /**
         * relative3 data img 相对数据3——图片
         */
        ImageView iv_img_relative3;

        /**
         * relative1 data layout 相对数据1——布局
         */
        LinearLayout ll_layout_relative1;

        /**
         * relative2 data layout 相对数据2——布局
         */
        RelativeLayout rl_layout_relative2;

        /**
         * relative3 data layout 相对数据3——布局
         */
        RelativeLayout rl_layout_relative3;

        /**
         * orientation1 data layout 水平数据1——布局
         */
        LinearLayout ll_layout_orientation1;

        /**
         * orientation2 data layout 水平数据2——布局
         */
        LinearLayout ll_layout_orientation2;

        /**
         * orientation3 data layout 水平数据3——布局
         */
        LinearLayout ll_layout_orientation3;

        /**
         * width of orientation1 layout 水平数据1宽度
         */
        int i_widthOrientation1;
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        /**
         * view list of viewpager 页卡view列表
         */
        ArrayList<View> list_Views = new ArrayList<View>();

        public MyViewHolder(View itemView) {
            super(itemView);
            vp_data = (ViewPager) itemView.findViewById(R.id.vp_item_index_topic);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_item_index_topic);
        }

        /**
         * inti orientation viewpageer views 加载水平页卡视图
         */
        public void initOrientatonViewPagerViews() {
            ll_view =
                    (LinearLayout) LayoutInflater.from(mContext).
                            inflate(R.layout.item_viewpager_index_orientation, null);
            list_Views = new ArrayList<View>();
            //orientation title 水平模式标题
            tv_title_orientation1 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_orientation1);
            tv_title_orientation2 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_orientation2);
            tv_title_orientation3 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_orientation3);
            //orientation info 水平模式描述
            tv_info_orientation1 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_orientation1);
            tv_info_orientation2 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_orientation2);
            tv_info_orientation3 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_orientation3);
            //orientation img 水平模式图片
            iv_img_orientation1 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_orientation1);
            iv_img_orientation2 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_orientation2);
            iv_img_orientation3 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_orientation3);
            //orientation layout 水平模式布局
            ll_layout_orientation1 =
                    (LinearLayout) ll_view.findViewById(R.id.ll_item_viepager_topic_orientation1);
            ll_layout_orientation2 =
                    (LinearLayout) ll_view.findViewById(R.id.ll_item_viepager_topic_orientation2);
            ll_layout_orientation3 =
                    (LinearLayout) ll_view.findViewById(R.id.ll_item_viepager_topic_orientation3);

        }

        /**
         * inti relative viewpageer views 加载相对页卡视图
         */
        public void initRelativeViewPagerVies() {
            ll_view =
                    (LinearLayout) LayoutInflater.from(mContext).
                            inflate(R.layout.item_viewpager_index_relative, null);
            list_Views = new ArrayList<View>();
            //relative title 相对模式标题
            tv_title_relative1 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_relative1);
            tv_title_relative2 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_relative2);
            tv_title_relative3 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_title_relative3);
            //relative info 相对模式描述
            tv_info_relative1 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_relative1);
            tv_info_relative2 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_relative2);
            tv_info_relative3 =
                    (TextView) ll_view.findViewById(R.id.tv_item_viepager_topic_info_relative3);
            //relative img 相对模式图片
            iv_img_relative1 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_relative1);
            iv_img_relative2 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_relative2);
            iv_img_relative3 =
                    (ImageView) ll_view.findViewById(R.id.iv_item_viepager_topic_img_relative3);
            //relative layout 相对模式布局
            ll_layout_relative1 =
                    (LinearLayout) ll_view.findViewById(R.id.ll_item_viepager_topic_relative1);
            rl_layout_relative2 =
                    (RelativeLayout) ll_view.findViewById(R.id.rl_item_viepager_topic_relative2);
            rl_layout_relative3 =
                    (RelativeLayout) ll_view.findViewById(R.id.rl_item_viepager_topic_relative3);
        }
    }


}