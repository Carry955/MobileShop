package com.carry.mobileshop02.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.carry.mobileshop02.R;
import com.carry.mobileshop02.activity.LoginActivity;
import com.carry.mobileshop02.common.BaseFragment;

public class PersonalFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container,false);
        Button bt_login = view.findViewById(R.id.personal_login);
        bt_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public int getContentViewId() {
        return R.layout.fragment_personal;
    }
}
