package com.xq.cartoon.collect.ui.fragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.ui.fragment.HomeFragment;
import com.xq.cartoon.collect.ui.fragment.RecordFragment;
import com.xq.cartoon.collect.ui.fragment.SettingFragment;
import com.xq.cartoon.collect.ui.fragment.entity.MainRadioButtonData;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/1 18:23
 **/
public class MainFragmentAdapter {
    private FragmentManager fm;
    private Fragment[] fg;
    private MainRadioButtonData[] datas;

    public MainFragmentAdapter(@NonNull MainRadioButtonData[] datas, FragmentManager fm) {
        this.datas = datas;
        this.fm = fm;
        fg = new Fragment[datas.length];
    }

    public void showFragment(int num) {
        FragmentTransaction transaction = fm.beginTransaction();
        for (int i = 0; i < fg.length; i++) {
            if (i == num) {
                if (fg[i] == null) {
                    fg[i] = foundFragment(datas[i].fragmentValue);
                    transaction.add(R.id.container, fg[i]);
                }
                transaction.show(fg[i]);
            } else if (fg[i] != null) {
                transaction.hide(fg[i]);
            }
        }
        transaction.commitAllowingStateLoss();
    }

    private Fragment foundFragment(int num) {
        switch (num) {
            case 2:
                return RecordFragment.getInstance();//记录，收藏
            case 3:
                return SettingFragment.getInstance();//设置
            default:
                return HomeFragment.getInstance();//首页，默认
        }
    }
}
