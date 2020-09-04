package com.xq.cartoon.collect.ui.activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.xq.cartoon.collect.ui.fragment.adapter.MainFragmentAdapter;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/4 1:09
 **/
public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> checkIndex;
    private MutableLiveData<MainFragmentAdapter> fragmentAdapter;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Integer> getCheckIndex() {
        synchronized (this) {
            if (checkIndex == null) {
                checkIndex = new MutableLiveData<>();
                checkIndex.setValue(0);
            }
            return checkIndex;
        }
    }

    public void setCheckIndex(Integer checkIndex) {
        getCheckIndex().setValue(checkIndex);
    }

    public MutableLiveData<MainFragmentAdapter> getFragmentAdapter() {
        synchronized (this) {
            if (fragmentAdapter == null) {
                fragmentAdapter = new MutableLiveData<>();
            }
            return fragmentAdapter;
        }
    }

    public void setFragmentAdapter(MainFragmentAdapter adapter) {
        getFragmentAdapter().setValue(adapter);
    }
}
