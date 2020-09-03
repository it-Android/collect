package com.xq.cartoon.collect.ui.activity.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/22 19:10
 **/
public class BaseActivity extends AppCompatActivity{

    public enum StatusBar {
        Transparent, Hide, Default
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeStatusBar(StatusBar.Default, false);
    }

    /**
     * 设置标题栏
     *
     * @param bar
     * @param dark
     */
    public void makeStatusBar(StatusBar bar, boolean dark) {
        Window window = getWindow();
        /**
         * View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR 字体图标全白
         * View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR 黑色
         */
        int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                (dark ? View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR : View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        if (bar == StatusBar.Hide) {
            //设置当前窗体为全屏显示
            int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
            window.setFlags(flag, flag);
        } else if (bar == StatusBar.Transparent) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (bar == StatusBar.Default) {
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        window.getDecorView().setSystemUiVisibility(option);
    }

}
