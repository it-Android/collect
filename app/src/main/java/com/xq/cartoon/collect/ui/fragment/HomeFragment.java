package com.xq.cartoon.collect.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.xq.cartoon.collect.R;
import com.xq.cartoon.collect.databinding.FragmentHomeBinding;
import com.xq.cartoon.collect.ui.fragment.base.BaseLoadingFragment;

/**
 * @作者(author)： JQ
 * @创建时间(date)： 2020/8/30 17:09
 **/
public class HomeFragment extends BaseLoadingFragment {
    private FragmentHomeBinding homeBinding;
    private HomeFragmentViewModel viewModel;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        //viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(HomeFragmentViewModel.class);
        viewModel = new ViewModelProvider(getActivity(),
                new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(HomeFragmentViewModel.class);
        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //默认选中位置发生变化了
        viewModel.getCheckIndex().observe(this, integer -> {

        });
    }
}
