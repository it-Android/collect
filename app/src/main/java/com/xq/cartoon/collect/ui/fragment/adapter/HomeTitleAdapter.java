package com.xq.cartoon.collect.ui.fragment.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.ui.fragment.entity.HomeItemData;
import com.xq.cartoon.collect.utils.AppConfig;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.List;

/**
 * 主页面home的标题头的适配器
 *
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/3 23:46
 **/
public class HomeTitleAdapter extends CommonNavigatorAdapter {
    private List<HomeItemData> itemData;
    private ViewPager viewPager;

    public HomeTitleAdapter(List<HomeItemData> itemData, ViewPager viewPager) {
        this.itemData = itemData;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        return itemData.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, int index) {
        final CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
        commonPagerTitleView.setContentView(R.layout.title_home_item_text_layout);
        commonPagerTitleView.setMinimumWidth(AppConfig.dip2px(context, 55));
        final TextView titleText = commonPagerTitleView.findViewById(R.id.tv_title);
        titleText.setText(itemData.get(index).name);
        commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
            @Override
            public void onSelected(int index, int totalCount) {
                titleText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }

            @Override
            public void onDeselected(int index, int totalCount) {
                titleText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));

            }

            @Override
            public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
                titleText.setScaleX(1.0f + (0.8f - 1.0f) * leavePercent);
                titleText.setScaleY(1.0f + (0.8f - 1.0f) * leavePercent);

            }

            @Override
            public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
                titleText.setScaleX(0.8f + (1.0f - 0.8f) * enterPercent);
                titleText.setScaleY(0.8f + (1.0f - 0.8f) * enterPercent);
            }
        });
        commonPagerTitleView.setOnClickListener(view -> {
            viewPager.setCurrentItem(index);
        });
        return commonPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        return null;
    }
}
