package com.xq.cartoon.collect.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.databinding.FragmentHomeBinding;
import com.xq.cartoon.collect.ui.fragment.adapter.HomeItemAdapter;
import com.xq.cartoon.collect.ui.fragment.adapter.HomeTitleAdapter;
import com.xq.cartoon.collect.ui.fragment.base.BaseLoadingFragment;
import com.xq.cartoon.collect.ui.fragment.entity.HomeItemData;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/30 17:09
 **/
public class HomeFragment extends BaseLoadingFragment {
    private FragmentHomeBinding homeBinding;
    private HomeFragmentViewModel viewModel;
    private HomeItemAdapter itemAdapter;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        //viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(HomeFragmentViewModel.class);
        viewModel = new ViewModelProvider(getActivity(),
                new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(HomeFragmentViewModel.class);
        List<HomeItemData> itemData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemData.add(new HomeItemData("测试" + i, null, i));
        }
        viewModel.setItemData(itemData);
        return homeBinding.getRoot();
    }

    private void setPage(List<HomeItemData> itemData) {
        itemAdapter = new HomeItemAdapter(getChildFragmentManager(), itemData);//添加
        homeBinding.viewPager.setAdapter(itemAdapter);//添加适配器
        homeBinding.viewPager.setOffscreenPageLimit(3);//预加载3个
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(false);//设置为true时强制一行显示,默认为false
        commonNavigator.setScrollPivotX(0.3f);//滚动中心
        commonNavigator.setAdapter(new HomeTitleAdapter(itemData, homeBinding.viewPager));//添加适配器
        homeBinding.viewPager.setCurrentItem(viewModel.getCheckIndex().getValue());
        homeBinding.magicIndicator.setNavigator(commonNavigator);//绑定文本显示器
        //监听viewPage的滑动
        homeBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                homeBinding.magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                homeBinding.magicIndicator.onPageSelected(position);
                viewModel.setCheckIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                homeBinding.magicIndicator.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //默认选中位置发生变化了
        viewModel.getItemData().observe(this, itemList -> {
            setPage(itemList);
        });

    }
}
