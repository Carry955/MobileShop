package com.example.mobileshop01.common;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initView();
        initData();
    }
    protected void initData(){

    }
    protected void initView(){

    }
    public abstract int getContentViewId();
    public void toastShort(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public void toastLong(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
