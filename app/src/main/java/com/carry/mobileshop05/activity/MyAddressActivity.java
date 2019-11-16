package com.carry.mobileshop05.activity;

import android.widget.TextView;

import com.carry.mobileshop05.R;
import com.carry.mobileshop05.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAddressActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId() {
        return R.layout.activity_my_address;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("我的地址");
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
