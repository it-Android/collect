package com.xq.cartoon.collect.ui.activity.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.utils.UIHelper;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/30 17:10
 **/
public class RootActivity extends BaseActivity {
    private final static String TAG = "RootActivity";
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        try {
            String className = getIntent().getStringExtra(UIHelper.FRAGMENT_CLASS);
            Log.i(TAG, String.format("fragment name %s", className));
            fragment = getSupportFragmentManager().findFragmentByTag(className);
            if (fragment == null) {
                fragment = (Fragment) Class.forName(className).newInstance();
            } else {
                fragment.setArguments(savedInstanceState);
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment, className);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
