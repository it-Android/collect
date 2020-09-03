package com.xq.cartoon.collect.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.ui.activity.base.BaseActivity;
import com.xq.cartoon.collect.databinding.ActivityGuideBinding;
import com.xq.cartoon.collect.utils.ThemeApplication;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity {
    ActivityGuideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_guide);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guide);

        binding.btn1.setOnClickListener((view) -> {
            ThemeApplication app = ((ThemeApplication) getApplication());
            if (app.theme == R.style.NightTheme) {
                app.theme = R.style.AppTheme;
            } else {
                app.theme = R.style.NightTheme;
            }
            startActivity(new Intent(this, MainActivity.class));
            recreate();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}