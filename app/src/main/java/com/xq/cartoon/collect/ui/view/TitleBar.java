package com.xq.cartoon.collect.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xq.cartoon.collect.R;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/9/1 20:25
 **/
public class TitleBar extends RelativeLayout {
    private int mLeftLayout;//左边
    private View mLeftView;
    private int mTopLayout;//上边
    private View mTopView;
    private int mRightLayout;//右边
    private View mRightView;
    private int mBottomLayout;//下边
    private View mBottomView;
    private int mCenterLayout;//中间
    private View mCenterView;
    private Context mContext;
    private LayoutInflater mInflater;

    public TitleBar(Context context) {
        super(context);
        initViews(context, null, 0);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs, defStyleAttr);
    }

    private void initViews(Context context, AttributeSet attributeSet, int defStyleAttr) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mInflater.inflate(R.layout.layout_title_bar_base, this, true);
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.title_bar_style, defStyleAttr, 0);
            mLeftLayout = typedArray.getResourceId(R.styleable.title_bar_style_left, -1);
            mTopLayout = typedArray.getResourceId(R.styleable.title_bar_style_top, -1);
            mRightLayout = typedArray.getResourceId(R.styleable.title_bar_style_right, -1);
            mBottomLayout = typedArray.getResourceId(R.styleable.title_bar_style_bottom, -1);
            mCenterLayout = typedArray.getResourceId(R.styleable.title_bar_style_center, -1);
            typedArray.recycle();
        }
    }

    public void setLeftLayout(int leftLayout) {
        if (leftLayout <= 0) return;
        this.mLeftLayout = leftLayout;
        setLeftView(mInflater.inflate(this.mLeftLayout, null));
    }

    public int getLeftLayout() {
        return mLeftLayout;
    }

    public View getLeftView() {
        return mLeftView;
    }

    public void setLeftView(View leftView) {
        if (leftView == null) return;
        if (this.mLeftView != null) removeView(leftView);
        this.mLeftView = leftView;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        ((ViewGroup) findViewById(R.id.title_left)).addView(this.mLeftView, params);
    }

    public void setTopLayout(int topLayout) {
        if (topLayout <= 0) return;
        this.mTopLayout = topLayout;
        setTopView(mInflater.inflate(this.mTopLayout, null));
    }

    public int getTopLayout() {
        return mTopLayout;
    }

    public View getTopView() {
        return mTopView;
    }

    public void setTopView(View topView) {
        if (topView == null) return;
        if (this.mTopView != null) removeView(topView);
        this.mTopView = topView;
        ((ViewGroup) findViewById(R.id.title_top)).addView(this.mTopView);
    }

    public int getRightLayout() {
        return mRightLayout;
    }

    public View getRightView() {
        return mRightView;
    }

    public void setRightLayout(int rightLayout) {
        if (rightLayout <= 0) return;
        this.mRightLayout = rightLayout;
        setRightView(mInflater.inflate(this.mRightLayout, null));
    }

    public void setRightView(View rightView) {
        if (rightView == null) return;
        if (this.mRightView != null) removeView(rightView);
        this.mRightView = rightView;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        ((ViewGroup) findViewById(R.id.title_right)).addView(this.mRightView, params);
    }

    public void setBottomLayout(int bottomLayout) {
        if (bottomLayout <= 0) return;
        this.mBottomLayout = bottomLayout;
        setBottomView(mInflater.inflate(this.mBottomLayout, null));
    }

    public int getBottomLayout() {
        return mBottomLayout;
    }

    public View getBottomView() {
        return mBottomView;
    }

    public void setBottomView(View bottomView) {
        if (bottomView == null) return;
        if (this.mBottomView != null) removeView(bottomView);
        this.mBottomView = bottomView;
        ((ViewGroup) findViewById(R.id.title_bottom)).addView(this.mBottomView);
    }

    public void setCenterLayout(int centerLayout) {
        if (centerLayout <= 0) return;
        this.mCenterLayout = centerLayout;
        setCenterView(mInflater.inflate(this.mCenterLayout, null));
    }

    public int getCenterLayout() {
        return mCenterLayout;
    }

    public View getCenterView() {
        return mCenterView;
    }

    public void setCenterView(View centerView) {
        if (centerView == null) return;
        if (this.mCenterView != null) removeView(centerView);
        this.mCenterView = centerView;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ((ViewGroup) findViewById(R.id.title_center)).addView(this.mCenterView, params);
    }

}
