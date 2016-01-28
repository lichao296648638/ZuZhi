package com.zuzhi.tianyou;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zuzhi.tianyou.activity.MapActivity;
import com.zuzhi.tianyou.base.BaseActivity;
import com.zuzhi.tianyou.base.BaseFragment;
import com.zuzhi.tianyou.fragment.ClassFragment;
import com.zuzhi.tianyou.fragment.IndexFragment;
import com.zuzhi.tianyou.fragment.IndexFragment2;
import com.zuzhi.tianyou.utils.AMapUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AMapLocationListener {

    /**
     * fragment manager 碎片管理器
     */
    private FragmentManager fm;

    /**
     * class fragment 类目碎片
     */
    private ClassFragment serviceFragment;

    /**
     * index fragment 首页碎片
     */
    private IndexFragment indexFragment;
    private IndexFragment2 indexFragment2;

    /**
     * fragment list 碎片列表
     */
    private List<BaseFragment> fragmentList = new ArrayList<BaseFragment>();

    /**
     * radio button 单选按钮
     */
    private int[] indexRadioIds = {R.id.rb_main_index,
            R.id.rb_main_service, R.id.rb_main_tender, R.id.rb_main_my};

    /**
     * 单选按钮组
     */
    private RadioGroup rg_main;

    /**
     * intent 意图
     */
    private Intent mIntent;
    //amap unit 高德地图组件相关
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    Handler mHandler = new Handler() {
        public void dispatchMessage(android.os.Message msg) {
            switch (msg.what) {
                //start location 开始定位
                case AMapUtils.MSG_LOCATION_START:
                    tv_title_bar_city.setText("...");
                    break;
                //location complete 定位完成
                case AMapUtils.MSG_LOCATION_FINISH:
                    AMapLocation loc = (AMapLocation) msg.obj;
//                    String result = AMapUtils.getLocationStr(loc);
                    String result = AMapUtils.getSimpleAddressStr(loc);
                    tv_title_bar_city.setText(result);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected int setContent() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        rg_main = (RadioGroup) findViewById(R.id.rg_main);

        rg_main.setOnCheckedChangeListener(this);

        rg_main.check(indexRadioIds[0]);


    }


    @Override
    protected void initTitleBar() {
        tv_title_bar_city = (TextView) findViewById(R.id.tv_title_bar_city);
        ll_title_bar_search = (LinearLayout) findViewById(R.id.ll_title_bar_search);
    }

    @Override
    protected void setTitleBar() {
        //open the steep mode 沉浸模式
        showSystemUI(getWindow().getDecorView());

        tv_title_bar_city.setVisibility(View.VISIBLE);
        ll_title_bar_search.setVisibility(View.VISIBLE);


        tv_title_bar_city.setOnClickListener(this);

        locationClient = new AMapLocationClient(getApplicationContext());
        locationOption = new AMapLocationClientOption();

        // set high precision location mode设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // set location listener 设置定位监听
        locationClient.setLocationListener(this);
        // keep location times 持续定位或单次定位
        locationOption.setOnceLocation(true);
        // set location params 设置定位参数
        locationClient.setLocationOption(locationOption);
        // start location 启动定位
        locationClient.startLocation();

        mHandler.sendEmptyMessage(AMapUtils.MSG_LOCATION_START);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        hideAllFragment();
        switch (checkedId) {
            case R.id.rb_main_service://service 服务
                if (serviceFragment == null) {
                    serviceFragment = new ClassFragment();
                    fragmentList.add(serviceFragment);
                    fm.beginTransaction().add(R.id.fm_main_container, serviceFragment)
                            .commit();
                } else {
                    fm.beginTransaction().show(serviceFragment).commit();
                }
                break;
            case R.id.rb_main_index://index 首页
                //if (indexFragment == null) {
                //    indexFragment = new IndexFragment();
                //    fragmentList.add(indexFragment);
                //    fm.beginTransaction().add(R.id.fm_main_container, indexFragment)
                //            .commit();
                //} else {
                //    fm.beginTransaction().show(indexFragment).commit();
                //}
                if (indexFragment2 == null) {
                    indexFragment2 = new IndexFragment2();
                    fragmentList.add(indexFragment2);
                    fm.beginTransaction().add(R.id.fm_main_container, indexFragment2)
                      .commit();
                } else {
                    fm.beginTransaction().show(indexFragment2).commit();
                }
                break;
            default:
                break;
        }
    }


    /**
     * hide all fragment 隐藏所有Fragment布局
     */
    private void hideAllFragment() {
        for (int i = 0; i < fragmentList.size(); i++) {
            fm.beginTransaction().hide(fragmentList.get(i)).commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //back  返回
            case R.id.ll_title_bar_left:
            case R.id.bt_title_bar_left:
                finish();
                break;
            //city 城市
            case R.id.tv_title_bar_city:
                mIntent = new Intent(this, MapActivity.class);
                startActivity(mIntent);
                break;
        }
    }

    // location listener 定位监听
    @Override
    public void onLocationChanged(AMapLocation loc) {
        if (null != loc) {
            Message msg = mHandler.obtainMessage();
            msg.obj = loc;
            msg.what = AMapUtils.MSG_LOCATION_FINISH;
            mHandler.sendMessage(msg);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //高德地图
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }
}
