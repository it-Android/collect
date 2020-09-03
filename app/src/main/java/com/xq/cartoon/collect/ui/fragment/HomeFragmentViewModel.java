package com.xq.cartoon.collect.ui.fragment;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/2 23:52
 **/
public class HomeFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> checkIndex;
    private Context mContext;

    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
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
}
