package com.xq.cartoon.collect.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.databinding.FragmentHomeItemBinding;
import com.xq.cartoon.collect.ui.fragment.base.BaseThemeFragment;
import com.xq.cartoon.collect.ui.fragment.entity.HomeItemData;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/3 20:51
 **/
public class HomeItemFragment extends BaseThemeFragment {
    public static final String ITEM_DATA = "itemData";
    private HomeItemData itemData;
    private FragmentHomeItemBinding itemBinding;

    public static HomeItemFragment getInstance(HomeItemData itemData) {
        HomeItemFragment fragment = new HomeItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ITEM_DATA, itemData);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = getArguments();
            itemData = bundle.getParcelable(ITEM_DATA);
        } else {
            itemData = savedInstanceState.getParcelable(ITEM_DATA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_item, container, false);
        itemBinding.itemTest.setText(itemData.name);
        return itemBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ITEM_DATA, itemData);
    }
}
