package com.zuzhi.tianyou.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.base.BaseActivity;

import org.w3c.dom.Text;

/**
 * confirm order activity 确认订单页面
 */
public class ConfirmOrderActivity extends BaseActivity implements View.OnClickListener {
    /**
     * eidit text of leave message to company 给服务商留言编辑框
     */
    private EditText et_message;

    /**
     * eidit text of leave message to company 给服务商留言编辑框
     */
    private TextView tv_commit_order;

    /** 开发票View */
    private TextView mMakeInvoice;


    @Override
    protected int setContent() {
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void initViews() {
        //find views
        et_message = (EditText) findViewById(R.id.et_confirm_order_message);
        tv_commit_order = (TextView) findViewById(R.id.tv_confirm_order_commit_order);
        mMakeInvoice = (TextView) findViewById(R.id.makeInvoice);
        // 解决嵌套在scrollview中无法获得焦点的问题
//        et_message.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View view, MotionEvent event) {
//                // TODO Auto-generated method stub
//                if (view.getId() == R.id.et_confirm_order_message) {
//                    view.getParent().requestDisallowInterceptTouchEvent(true);
//                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
//                        case MotionEvent.ACTION_UP:
//                            view.getParent().requestDisallowInterceptTouchEvent(false);
//                            break;
//                    }
//                }
//                return false;
//            }
//        });
        //set listeners
        tv_commit_order.setOnClickListener(this);
        mMakeInvoice.setOnClickListener(this);
    }

    @Override
    protected void initTitleBar() {
        ll_title_bar_left = (LinearLayout) findViewById(R.id.ll_title_bar_left);
        tv_title_bar_text = (TextView) findViewById(R.id.tv_title_bar_title);
        bt_title_bar_left = (Button) findViewById(R.id.bt_title_bar_left);
    }

    @Override
    protected void setTitleBar() {
        //open the steep mode 沉浸模式
        TitileBarSteep(getWindow().getDecorView());

        ll_title_bar_left.setVisibility(View.VISIBLE);
        tv_title_bar_text.setVisibility(View.VISIBLE);
        bt_title_bar_left.setVisibility(View.VISIBLE);

        tv_title_bar_text.setText(getResources().getString(R.string.confirm_order));

        ll_title_bar_left.setOnClickListener(this);
        bt_title_bar_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //back 返回键
            case R.id.ll_title_bar_left:
            case R.id.bt_title_bar_left:
                finish();
                break;
            //commit order 提交订单
            case R.id.tv_confirm_order_commit_order:
                finish();
                break;
            case R.id.makeInvoice:
                startActivity(new Intent(this, MakeInvoiceActivity.class));
                break;
        }

    }
}
