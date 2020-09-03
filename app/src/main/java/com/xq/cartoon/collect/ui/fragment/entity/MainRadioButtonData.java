package com.xq.cartoon.collect.ui.fragment.entity;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/31 0:41
 **/
public class MainRadioButtonData {
    public int id;// 唯一id  不需要传入，在循环动态创建就可以了
    public String name;//标签名字
    public int resBgId;//背景资源
    public int fragmentValue;//页面类型

    public MainRadioButtonData(String name, int resBgId, int fragmentValue) {
        this.name = name;
        this.resBgId = resBgId;
        this.fragmentValue = fragmentValue;
    }

    public MainRadioButtonData() {
    }
}
