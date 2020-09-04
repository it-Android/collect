package com.xq.cartoon.collect.ui.fragment;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.xq.cartoon.collect.ui.fragment.entity.HomeItemData;

import java.util.List;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/2 23:52
 **/
public class HomeFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> checkIndex;
    private MutableLiveData<List<HomeItemData>> itemData;
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

    public MutableLiveData<List<HomeItemData>> getItemData() {
        synchronized (this) {
            if (itemData == null) {
                itemData = new MutableLiveData<>();
                //itemData.setValue(new ArrayList<>());
            }
        }
        return itemData;
    }

    public void setItemData(List<HomeItemData> list) {
        getItemData().setValue(list);
    }

}
