package com.zuzhi.tianyou.activity;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zuzhi.tianyou.R;
import com.zuzhi.tianyou.base.BaseActivity;

/**
 * 开具发票页面.
 * Created by Corydon on 2016/3/1.
 */
public class MakeInvoiceActivity extends BaseActivity implements View.OnClickListener {

    /** 普通发票的View */
    private View mItemInvoiceCommon;
    /** 公司名称的editText */
    private EditText mItemInvoiceCommonFirmName;
    /** 收件人editText */
    private EditText mItemInvoiceCommonAddressee;
    /** 手机号editText */
    private EditText mItemInvoiceCommonPhoneNumber;
    /** 邮政编码editText */
    private EditText mItemInvoiceCommonZIPCode;
    /** 所在地editText */
    private EditText mItemInvoiceCommonLocation;
    /** 街道editText */
    private EditText mItemInvoiceCommonStreet;
    /** 详细地址editText */
    private EditText mItemInvoiceCommonDetailedAddress;

    /** 增值税发票的View */
    private View mItemInvoiceVAT;
    /** 单位名称TextView */
    private TextView mItemInvoiceVATTextViewCompanyName;
    /** 单位名称editText */
    private EditText mItemInvoiceVATCompanyName;
    /** 纳税人识别码TextView */
    private TextView mItemInvoiceVATTextViewTaxpayerID;
    /** 纳税人识别码editText */
    private EditText mItemInvoiceVATTaxpayerID;
    /** 注册地址TextView */
    private TextView mItemInvoiceVATTextViewRegisterAddress;
    /** 注册地址editText */
    private EditText mItemInvoiceVATRegisterAddress;
    /** 注册电话TextView */
    private TextView mItemInvoiceVATTextViewRegisterPhone;
    /** 注册电话editText */
    private EditText mItemInvoiceVATRegisterPhone;
    /** 开户银行TextView */
    private TextView mItemInvoiceVATTextViewDepositBank;
    /** 开户银行editText */
    private EditText mItemInvoiceVATDepositBank;
    /** 银行账号TextView */
    private TextView mItemInvoiceVATTextViewBankAccount;
    /** 银行账号editText */
    private EditText mItemInvoiceVATBankAccount;
    /** 收件人editText */
    private EditText mItemInvoiceVATAddressee;
    /** 手机号editText */
    private EditText mItemInvoiceVATPhoneNumber;
    /** 邮政编码editText */
    private EditText mItemInvoiceVATZIPCode;
    /** 所在地editText */
    private EditText mItemInvoiceVATLocation;
    /** 街道editText */
    private EditText mItemInvoiceVATStreet;
    /** 详细地址editText */
    private EditText mItemInvoiceVATDetailedAddress;

    /** 普通发票RadioButton */
    private RadioButton mInvoiceCommonButton;
    /** 增值税发票RadioButton */
    private RadioButton mInvoiceVATButton;
    private FrameLayout mFrameLayout;

    @Override
    protected int setContent() {
        return R.layout.activity_make_invoice;
    }

    @Override
    protected void initViews() {
        mInvoiceCommonButton = (RadioButton) findViewById(R.id.invoiceCommonButton);
        mInvoiceVATButton = (RadioButton) findViewById(R.id.invoiceVATButton);
        mFrameLayout = (FrameLayout) findViewById(R.id.invoice_content_layout);

        mInvoiceCommonButton.setOnClickListener(this);
        mInvoiceVATButton.setOnClickListener(this);

        initItemInvoiceCommon();
        initItemInvoiceVAT();

        mFrameLayout.addView(mItemInvoiceCommon);
        mInvoiceVATButton.setTextColor(Color.GRAY);
        mInvoiceCommonButton.setSelected(true);
        findViewById(R.id.invoiceAffirmButton).setOnClickListener(this);
        findViewById(R.id.invoiceLeaveButton).setOnClickListener(this);
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

        tv_title_bar_text.setText(getResources().getString(R.string.make_invoiec));

        ll_title_bar_left.setOnClickListener(this);
        bt_title_bar_left.setOnClickListener(this);
    }

    public void initItemInvoiceCommon() {
        mItemInvoiceCommon = LayoutInflater.from(this).inflate(R.layout.item_invoice_common, null);
        mItemInvoiceCommonAddressee = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonAddressee);
        mItemInvoiceCommonDetailedAddress = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonDetailedAddress);
        mItemInvoiceCommonFirmName = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonFirmName);
        mItemInvoiceCommonLocation = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonLocation);
        mItemInvoiceCommonPhoneNumber = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonPhoneNumber);
        mItemInvoiceCommonStreet = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonStreet);
        mItemInvoiceCommonZIPCode = (EditText) mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonZIPCode);

        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewAddressee).setOnClickListener(this);
        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewDetailedAddress).setOnClickListener(this);
        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewLocation).setOnClickListener(this);
        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewPhoneNumber).setOnClickListener(this);
        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewStreet).setOnClickListener(this);
        mItemInvoiceCommon.findViewById(R.id.itemInvoiceCommonTextViewZIPCode).setOnClickListener(this);
    }

    public void initItemInvoiceVAT() {
        mItemInvoiceVAT = LayoutInflater.from(this).inflate(R.layout.item_invoice_vat, null);
        /** 需要改变颜色的TextView */
        mItemInvoiceVATTextViewCompanyName = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewCompanyName);
        mItemInvoiceVATTextViewTaxpayerID = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewTaxpayerID);
        mItemInvoiceVATTextViewRegisterAddress = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewRegisterAddress);
        mItemInvoiceVATTextViewRegisterPhone = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewRegisterPhone);
        mItemInvoiceVATTextViewDepositBank = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewDepositBank);
        mItemInvoiceVATTextViewBankAccount = (TextView) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewBankAccount);
        /** 带*号的EditText */
        mItemInvoiceVATCompanyName = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATCompanyName);
        mItemInvoiceVATTaxpayerID = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTaxpayerID);
        mItemInvoiceVATRegisterAddress = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATRegisterAddress);
        mItemInvoiceVATRegisterPhone = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATRegisterPhone);
        mItemInvoiceVATDepositBank = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATDepositBank);
        mItemInvoiceVATBankAccount = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATBankAccount);
        /** 普通EditText */
        mItemInvoiceVATAddressee = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATAddressee);
        mItemInvoiceVATDetailedAddress = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATDetailedAddress);
        mItemInvoiceVATLocation = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATLocation);
        mItemInvoiceVATPhoneNumber = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATPhoneNumber);
        mItemInvoiceVATStreet = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATStreet);
        mItemInvoiceVATZIPCode = (EditText) mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATZIPCode);

        /** 设置必填项*号和字体的颜色 */
        SpannableString mSpCompanyName = new SpannableString("* 单位名称");
        mSpCompanyName.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpCompanyName.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewCompanyName.setText(mSpCompanyName);
        SpannableString mSpTaxpayerID = new SpannableString("* 纳税人识别码");
        mSpTaxpayerID.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpTaxpayerID.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewTaxpayerID.setText(mSpTaxpayerID);
        SpannableString mSpRegisterAddress = new SpannableString("* 注册地址");
        mSpRegisterAddress.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpRegisterAddress.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewRegisterAddress.setText(mSpRegisterAddress);
        SpannableString mSpRegisterPhone = new SpannableString("* 注册电话");
        mSpRegisterPhone.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpRegisterPhone.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewRegisterPhone.setText(mSpRegisterPhone);
        SpannableString mSpDepositBank = new SpannableString("* 开户银行");
        mSpDepositBank.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpDepositBank.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewDepositBank.setText(mSpDepositBank);
        SpannableString mSpBankAccount = new SpannableString("* 银行账号");
        mSpBankAccount.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpBankAccount.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_text_identifying_code_disable)), 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mItemInvoiceVATTextViewBankAccount.setText(mSpBankAccount);

        mItemInvoiceVATTextViewCompanyName.setOnClickListener(this);
        mItemInvoiceVATTextViewTaxpayerID.setOnClickListener(this);
        mItemInvoiceVATTextViewRegisterAddress.setOnClickListener(this);
        mItemInvoiceVATTextViewRegisterPhone.setOnClickListener(this);
        mItemInvoiceVATTextViewDepositBank.setOnClickListener(this);
        mItemInvoiceVATTextViewBankAccount.setOnClickListener(this);

        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewAddressee).setOnClickListener(this);
        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewDetailedAddress).setOnClickListener(this);
        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewLocation).setOnClickListener(this);
        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewPhoneNumber).setOnClickListener(this);
        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewStreet).setOnClickListener(this);
        mItemInvoiceVAT.findViewById(R.id.itemInvoiceVATTextViewZIPCode).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //back 返回键
            case R.id.invoiceLeaveButton:
            case R.id.ll_title_bar_left:
            case R.id.bt_title_bar_left:
                finish();
                break;
            /** 点击普通与增值税发票 button间 背景颜色与字体颜色的切换 */
            case R.id.invoiceCommonButton:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(mItemInvoiceCommon);
                mInvoiceCommonButton.setSelected(true);
                mInvoiceCommonButton.setTextColor(Color.WHITE);
                mInvoiceVATButton.setTextColor(Color.GRAY);
                mInvoiceVATButton.setSelected(false);
                break;
            case R.id.invoiceVATButton:
                mFrameLayout.removeAllViews();
                mFrameLayout.addView(mItemInvoiceVAT);
                mInvoiceCommonButton.setSelected(false);
                mInvoiceCommonButton.setTextColor(Color.GRAY);
                mInvoiceVATButton.setTextColor(Color.WHITE);
                mInvoiceVATButton.setSelected(true);
                break;
            /** 普通发票 点击TextView拿到同一行的EditText焦点 */
            case R.id.itemInvoiceCommonTextViewAddressee:
                mItemInvoiceCommonAddressee.setFocusable(true);
                mItemInvoiceCommonAddressee.requestFocus();
                break;
            case R.id.itemInvoiceCommonTextViewDetailedAddress:
                mItemInvoiceCommonDetailedAddress.setFocusable(true);
                mItemInvoiceCommonDetailedAddress.requestFocus();
                break;
            case R.id.itemInvoiceCommonTextViewLocation:
                mItemInvoiceCommonLocation.setFocusable(true);
                mItemInvoiceCommonLocation.requestFocus();
                break;
            case R.id.itemInvoiceCommonTextViewPhoneNumber:
                mItemInvoiceCommonPhoneNumber.setFocusable(true);
                mItemInvoiceCommonPhoneNumber.requestFocus();
                break;
            case R.id.itemInvoiceCommonTextViewStreet:
                mItemInvoiceCommonStreet.setFocusable(true);
                mItemInvoiceCommonStreet.requestFocus();
                break;
            case R.id.itemInvoiceCommonTextViewZIPCode:
                mItemInvoiceCommonZIPCode.setFocusable(true);
                mItemInvoiceCommonZIPCode.requestFocus();
                break;
            /** 增值税发票 点击TextView拿到同一行的EditText焦点 */
            case R.id.itemInvoiceVATTextViewAddressee:
                mItemInvoiceVATAddressee.setFocusable(true);
                mItemInvoiceVATAddressee.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewBankAccount:
                mItemInvoiceVATBankAccount.setFocusable(true);
                mItemInvoiceVATBankAccount.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewCompanyName:
                mItemInvoiceVATCompanyName.setFocusable(true);
                mItemInvoiceVATCompanyName.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewDepositBank:
                mItemInvoiceVATDepositBank.setFocusable(true);
                mItemInvoiceVATDepositBank.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewDetailedAddress:
                mItemInvoiceVATDetailedAddress.setFocusable(true);
                mItemInvoiceVATDetailedAddress.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewLocation:
                mItemInvoiceVATLocation.setFocusable(true);
                mItemInvoiceVATLocation.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewPhoneNumber:
                mItemInvoiceVATPhoneNumber.setFocusable(true);
                mItemInvoiceVATPhoneNumber.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewRegisterAddress:
                mItemInvoiceVATRegisterAddress.setFocusable(true);
                mItemInvoiceVATRegisterAddress.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewRegisterPhone:
                mItemInvoiceVATRegisterPhone.setFocusable(true);
                mItemInvoiceVATRegisterPhone.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewStreet:
                mItemInvoiceVATStreet.setFocusable(true);
                mItemInvoiceVATStreet.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewTaxpayerID:
                mItemInvoiceVATTaxpayerID.setFocusable(true);
                mItemInvoiceVATTaxpayerID.requestFocus();
                break;
            case R.id.itemInvoiceVATTextViewZIPCode:
                mItemInvoiceVATZIPCode.setFocusable(true);
                mItemInvoiceVATZIPCode.requestFocus();
                break;
            /** 确认button的判断与提交 */
            case R.id.invoiceAffirmButton:
                if (mInvoiceVATButton.isSelected()) {
                    if (TextUtils.isEmpty(mItemInvoiceVATCompanyName.getText().toString())) {
                        Toast.makeText(this, "请输入单位名称!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mItemInvoiceVATTaxpayerID.getText().toString())) {
                        Toast.makeText(this, "请输入纳税人识别码！", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mItemInvoiceVATRegisterAddress.getText().toString())) {
                        Toast.makeText(this, "请输入注册地址！", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mItemInvoiceVATRegisterPhone.getText().toString())) {
                        Toast.makeText(this, "请输入注册电话！", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mItemInvoiceVATDepositBank.getText().toString())) {
                        Toast.makeText(this, "请输入开户银行！", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (TextUtils.isEmpty(mItemInvoiceVATBankAccount.getText().toString())) {
                        Toast.makeText(this, "请输入银行账号！", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Log.i("Corydon", "invoiceAffirmButton ------> ");
                break;
        }
    }
}
