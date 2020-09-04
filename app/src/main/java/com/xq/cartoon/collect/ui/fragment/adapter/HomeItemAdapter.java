package com.xq.cartoon.collect.ui.fragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.xq.cartoon.collect.ui.fragment.HomeItemFragment;
import com.xq.cartoon.collect.ui.fragment.entity.HomeItemData;

import java.util.List;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/3 20:52
 **/
public class HomeItemAdapter extends FragmentStatePagerAdapter {
    private List<HomeItemData> homeItemData;

    public HomeItemAdapter(@NonNull FragmentManager fm, List<HomeItemData> homeItemData) {
        super(fm);
        this.homeItemData = homeItemData;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return HomeItemFragment.getInstance(homeItemData.get(position));
    }

    @Override
    public int getCount() {
        return homeItemData.size();
    }
}
