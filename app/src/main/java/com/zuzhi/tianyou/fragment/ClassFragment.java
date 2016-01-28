package com.zuzhi.tianyou.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.base.BaseFragment;
import com.zuzhi.tianyou.adapter.listviewadapter.ClassLevelOneAdapter;
import com.zuzhi.tianyou.adapter.listviewadapter.ClassLevelTwoAdapter;


import java.util.ArrayList;
import java.util.HashMap;

public class ClassFragment extends BaseFragment implements View.OnClickListener {

    /**
     * data of class category 服务类目数据源
     */
    private ArrayList<HashMap<String, Object>> mData;

    /**
     * list of class level one 一级类目列表
     */
    private ListView lv_class_level_one;

    /**
     * list of class level two 二级类目列表
     */
    private ListView lv_class_level_two;



    @Override
    protected void setTitleBar() {

    }

    @Override
    protected int setLayoutID() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView(View view) {

        //data source 数据源
        mData = new ArrayList<HashMap<String, Object>>();

        //init data 加载数据源
        for (int i = 0; i < 10; i++) {
            String[] s_threeLevel = new String[]{"三级类目1", "三级类目2", "三级类目3"};
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("level_one", "一级类目");
            map.put("level_one_id", String.valueOf(i));
            map.put("level_two", "二级类目");
            map.put("level_three", s_threeLevel);
            mData.add(map);

        }


        //list of class one 一级类目列表
        lv_class_level_one = (ListView) view.findViewById(R.id.lv_class_level_one);
        final ClassLevelOneAdapter classLevelOneAdapter = new ClassLevelOneAdapter(mData, getActivity());
        lv_class_level_one.setAdapter(classLevelOneAdapter);

        //list of class two 二级类目列表
        lv_class_level_two = (ListView) view.findViewById(R.id.lv_class_level_two);
        final ClassLevelTwoAdapter classLevelTwoAdapter = new ClassLevelTwoAdapter(mData, getActivity());
        lv_class_level_two.setAdapter(classLevelTwoAdapter);

        //change class level one when touched 一级类目点击更换布局
        lv_class_level_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int lastPosition = classLevelOneAdapter.getSelection();
                if (position == lastPosition) {
                    return;
                }
                int firstVisiblePosition = lv_class_level_one.getFirstVisiblePosition();
                int childCount = lv_class_level_one.getChildCount();
                if (lastPosition >= firstVisiblePosition && lastPosition <= firstVisiblePosition + childCount) {
                    classLevelOneAdapter.setSelectionView(parent.getChildAt(lastPosition - firstVisiblePosition), false);
                }

                //change class levle one 更换一级布局
                classLevelOneAdapter.setSelection(position);
                if (position >= firstVisiblePosition && position <= firstVisiblePosition + childCount) {
                    classLevelOneAdapter.setSelectionView(view, true);
                }

                //change class levle two 更换二级布局
                classLevelTwoAdapter.setSelection(position);
                classLevelTwoAdapter.notifyDataSetChanged();
                lv_class_level_two.setSelection(0);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }


}

