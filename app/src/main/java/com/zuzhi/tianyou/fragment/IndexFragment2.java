package com.zuzhi.tianyou.fragment;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.adapter.recyclerviewadapter.IndexTopicAdapter2;
import com.zuzhi.tianyou.base.BaseFragment;
import com.zuzhi.tianyou.entity.ImageEntity;
import com.zuzhi.tianyou.utils.Cons;
import com.zuzhi.tianyou.views.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexFragment2 extends BaseFragment {
    @Override
    protected void initTitleBar(View view) {

    }

    @Override
    protected void setTitleBar() {

    }

    @Override
    protected int setLayoutID() {
        return R.layout.fragment_index2;
    }

    @Override
    protected void initView(View view) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        // 轮播图片。
        Map<String, Object> map = new HashMap<>();
        dataList.add(map);
        map.put("viewType", 0);
        List<ImageEntity> list = new ArrayList<>();
        map.put("images", list);
        for (int i = 0; i < 4; i++) {
            ImageEntity entity = new ImageEntity();
            entity.setUrl("http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg");
            list.add(entity);
        }
        // 最近访问。
        map = new HashMap<>();
        dataList.add(map);
        map.put("viewType", 1);
        ArrayList<HashMap<String, Object>> list1 = new ArrayList<>();
        map.put("texts", list1);
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("string", "最近访问" + i);
            list1.add(item);
        }
        // 八宫格 1。
        map = new HashMap<>();
        dataList.add(map);
        map.put("viewType", 2);
        list1 = new ArrayList<>();
        map.put("data", list1);
        String[] texts = new String[]{"商务代理", "鉴证业务", "策划咨询", "兼并上市"};
        int[] images = new int[]{R.drawable.home_module1, R.drawable.home_module2, R.drawable.home_module3,
                                 R.drawable.home_module4};
        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("string", texts[i]);
            item.put("image", getContext().getResources().getDrawable(images[i]));
            list1.add(item);
        }
        // 八宫格 2。
        map = new HashMap<>();
        dataList.add(map);
        map.put("viewType", 2);
        list1 = new ArrayList<>();
        map.put("data", list1);
        texts = new String[]{"小微企业", "中大企业",
                             "上市公司", "自营业务"};
        images = new int[]{R.drawable.home_module5, R.drawable.home_module6, R.drawable.home_module7,
                           R.drawable.home_module8};
        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("string", texts[i]);
            item.put("image", getContext().getResources().getDrawable(images[i]));
            list1.add(item);
        }
        // 在线客服。
        map = new HashMap<>();
        dataList.add(map);
        map.put("viewType", 3);
        // 剩余列表。
        for (int i = 0; i < 9; i++) {
            map = new HashMap<>();
            dataList.add(map);
            map.put("viewType", 4);
            map.put("title", "title " + i);
            list1 = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                HashMap<String, Object> data = new HashMap<>();
                data.put("title1", "title1 " + i + "-" + j);
                data.put("title2", "title2 " + i + "-" + j);
                data.put("drawable", getContext().getResources().getDrawable(R.drawable.home_module5));
                list1.add(data);
            }
            map.put("data", list1);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_index_topic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false));
        recyclerView.setAdapter(new IndexTopicAdapter2(getContext(), dataList));

    }
}

