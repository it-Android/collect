package com.xq.cartoon.collect.ui.fragment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/3 20:45
 **/
public class HomeItemData implements Parcelable {
    public HomeItemData() {
    }

    public HomeItemData(String name, List<Object> dataList, int themeId) {
        this.name = name;
        this.dataList = dataList;
        this.themeId = themeId;
    }

    public String name;
    public List<Object> dataList;
    public int themeId;

    protected HomeItemData(Parcel in) {
        name = in.readString();
        themeId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(themeId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeItemData> CREATOR = new Creator<HomeItemData>() {
        @Override
        public HomeItemData createFromParcel(Parcel in) {
            return new HomeItemData(in);
        }

        @Override
        public HomeItemData[] newArray(int size) {
            return new HomeItemData[size];
        }
    };
}
