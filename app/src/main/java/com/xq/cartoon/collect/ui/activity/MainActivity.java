package com.xq.cartoon.collect.ui.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.databinding.DataBindingUtil;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.ui.activity.base.BaseActivity;
import com.xq.cartoon.collect.databinding.ActivityMainBinding;
import com.xq.cartoon.collect.ui.fragment.adapter.MainFragmentAdapter;
import com.xq.cartoon.collect.ui.fragment.entity.MainRadioButtonData;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private ActivityMainBinding binding;
    private MainFragmentAdapter fragmentAdapter;
    private static MainRadioButtonData[] datas = {
            new MainRadioButtonData("首页", 0, 0),
            new MainRadioButtonData("书架", 0, 2),
            new MainRadioButtonData("我的", 0, 3)
    };
    private int checkNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        fragmentAdapter = new MainFragmentAdapter(datas, getSupportFragmentManager());
        initBottomNavigationHolder(binding.bottomNavigationHolder);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (MainRadioButtonData data : datas) {
            if (data.id == checkedId) {
                this.checkNum = checkedId;
                fragmentAdapter.showFragment(this.checkNum);
                return;
            }
        }
    }

    //底部导航栏
    private void initBottomNavigationHolder(RadioGroup radioGroup) {
        for (int i = 0; i < datas.length; i++) {
            MainRadioButtonData data = datas[i];
            data.id = i;
            radioGroup.addView(foundRadioButton(data));//创建 底部导航栏
        }
        radioGroup.setOnCheckedChangeListener(this::onCheckedChanged);
        int length = datas.length;
        if (length > 0 && checkNum < length) {
            ((RadioButton) radioGroup.getChildAt(this.checkNum)).setChecked(true);
        }
    }

    //底部创建按钮
    private RadioButton foundRadioButton(MainRadioButtonData data) {
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(data.name);
        radioButton.setId(data.id);
        radioButton.setGravity(Gravity.CENTER);
        radioButton.setLayoutParams(new RadioGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        return radioButton;
    }

}