package com.xq.cartoon.collect.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.ui.fragment.base.BaseLoadingFragment;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/30 17:09
 **/
public class SettingFragment extends BaseLoadingFragment {

    public static SettingFragment getInstance() {
        return new SettingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}
