package com.carry.mobileshop02.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.carry.mobileshop02.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private EditText et_username;
    private EditText et_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
        String user_name = getIntent().getStringExtra("user_name");
        Log.d(TAG,"user_name = " + user_name);
        et_username.setText(user_name);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_login:
                String user_name = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();
                if(TextUtils.isEmpty(user_name)){
                    Toast.makeText(LoginActivity.this,"用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this,"密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("用户名：" + user_name + "密码" + pwd)
                        .show();
                break;
        }
    }
}
