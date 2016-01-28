package com.zuzhi.tianyou.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.adapter.recyclerviewadapter.IndexTopicAdapter2;
import com.zuzhi.tianyou.base.BaseFragment;
import com.zuzhi.tianyou.bean.AccessHistory;
import com.zuzhi.tianyou.bean.BaGongGe;
import com.zuzhi.tianyou.bean.IndexHome;
import com.zuzhi.tianyou.bean.SanGongGe;
import com.zuzhi.tianyou.bean.SanGongGeItem;
import com.zuzhi.tianyou.entity.ImageEntity;
import com.zuzhi.tianyou.utils.Cons;

import java.util.ArrayList;

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
        IndexHome home = new IndexHome();
        // 轮播图片。
        home.bannerImageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageEntity entity = new ImageEntity();
            entity.setUrl("http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg");
            home.bannerImageList.add(entity);
        }
        // 最近访问。
        home.accessHistoryList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AccessHistory history = new AccessHistory();
            history.text = "最近访问" + i;
            home.accessHistoryList.add(history);
        }
        // 八宫格。
        home.baGongGeList = new ArrayList<>();
        for (int i = 0; i < Cons.STRARR_INDEX_GUIDE.length; i++) {
            BaGongGe baGongGe = new BaGongGe();
            baGongGe.text = Cons.STRARR_INDEX_GUIDE[i];
            baGongGe.img = "drawable://" + Cons.ID_DRAWABLE_INDEX_GUIDE[i];
            home.baGongGeList.add(baGongGe);
        }
        // 在线客服。

        // 剩余列表。
        home.sanGongGeList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            SanGongGe sanGongGe = new SanGongGe();
            sanGongGe.title = "title " + i;
            sanGongGe.list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                SanGongGeItem item = new SanGongGeItem();
                item.title = "title1 " + i + "-" + j;
                item.title2 = "title2 " + i + "-" + j;
                item.img = "drawable://" + R.drawable.home_module5;
                sanGongGe.list.add(item);
            }
            home.sanGongGeList.add(sanGongGe);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_index_topic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false));
        recyclerView.setAdapter(new IndexTopicAdapter2(getContext(), home));

    }
}

