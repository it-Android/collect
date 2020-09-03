package com.xq.cartoon.collect.utils;

import android.app.Application;
import com.xq.cartoon.collect.R;
/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/23 11:52
 **/
public class ThemeApplication extends Application {
    public int theme = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        theme= R.style.AppTheme;
    }
}
