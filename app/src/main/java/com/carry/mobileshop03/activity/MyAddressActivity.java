package com.carry.mobileshop03.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.carry.mobileshop03.R;
import com.carry.mobileshop03.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
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
