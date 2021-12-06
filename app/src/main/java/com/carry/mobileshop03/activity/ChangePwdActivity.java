package com.carry.mobileshop03.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.carry.mobileshop03.R;
import com.carry.mobileshop03.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_change_pwd;
    }

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("修改密码");
    }
    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
