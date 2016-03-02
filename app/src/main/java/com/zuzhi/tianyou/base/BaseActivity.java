package com.zuzhi.tianyou.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuzhi.tianyou.R;


/**
 * BaseActivity 基Activity
 *
 * @author lichao
 */
public abstract class BaseActivity extends FragmentActivity {

    protected Context mContext;

    /**
     * left title bar layout 左标题栏布局
     */
    protected LinearLayout ll_title_bar_left;

    /**
     * title text of title bar 标题栏标题文字
     */
    protected TextView tv_title_bar_text;

    /**
     * left button 左按键
     */
    protected Button bt_title_bar_left;

    /**
     * search layout 搜索布局
     */
    protected RelativeLayout rl_title_bar_search;

    /**
     * right layout 右布局
     */
    protected LinearLayout ll_title_bar_right;

    /**
     * right layout text 右布局文字
     */
    protected TextView tv_title_bar_right;

    /**
     * offset of title bar标题栏偏移量
     *
     * @param savedInstanceState
     */
    protected ImageView iv_title_bar_offset;

    /**
     * city 城市
     */
    protected TextView tv_title_bar_city;

    /**
     * search bar whith icon 图片按钮搜索栏
     */
    protected LinearLayout ll_title_bar_search_icon;

    /**
     * search button of search bar搜索栏搜索按钮
     */
    protected Button bt_title_bar_search;

    /**
     * layout of titile bar标题栏布局
     */
    protected LinearLayout ll_title_bar;

    protected Bundle mSavedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mContext = getApplicationContext();
        setContentView(setContent());
        getIntentData();
        initViews();
        initTitleBar();
        setTitleBar();
    }

    /**
     * set layout 设置布局文件
     *
     * @return layout ID 布局ID
     */
    protected abstract int setContent();

    /**
     * init views 初始化控件
     *
     * @return
     */
    protected abstract void initViews();

    /**
     * init title bar 初始化标题
     *
     * @return
     */
    protected abstract void initTitleBar();

    /**
     * set title bar 设置标题
     *
     * @return
     */
    protected abstract void setTitleBar();

    /**
     * get intent data 获得意图数据
     */
    protected void getIntentData() {

    }


    /**
     * hide status bar 隐藏状态栏
     *
     * @param view
     */
    @SuppressLint("NewApi")
    protected void
    hideSystemUI(View view) {
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    /**
     * steep mode wiht titlebar 有标题栏沉浸
     *
     * @param view
     */
    @SuppressLint("NewApi")
    protected void TitileBarSteep(View view) {
        //if the api level >= 19, open the steep mode 沉浸模式
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //offset the title bar 偏移标题栏
//            LinearLayout.LayoutParams params =
//                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.height = getStatusBarHeight();
//            iv_title_bar_offset = (ImageView) findViewById(R.id.iv_title_bar_offset);
//            iv_title_bar_offset.setLayoutParams(params);
//            //alpha status bar 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //alpha navigation bar 透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            view.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//
//        }

    }

    /**
     * steep mode without titlebar 无标题栏沉浸
     * @param view
     */
    protected void NormalSteep(View view) {
//        //open the steep mode 沉浸模式
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //alpha status bar 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //alpha navigation bar 透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
    }
    /**
     * get the height of status bar 获取状态栏高度
     *
     * @return
     */
    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
