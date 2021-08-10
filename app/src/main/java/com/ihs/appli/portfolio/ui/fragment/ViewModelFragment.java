package com.ihs.appli.portfolio.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ihs.appli.portfolio.R;

import javax.inject.Inject;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import pub.devrel.easypermissions.EasyPermissions;

public abstract class ViewModelFragment<V extends ViewModel> extends Fragment {

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;

    protected V viewModel;


    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(getViewModel());
    }


    @BindDrawable(R.drawable.ic_baseline_expand_less_24)
    Drawable expandLess;
    @BindDrawable(R.drawable.ic_baseline_expand_more_24)
    Drawable expandMore;

    public void collapseExpand(TextView header, LinearLayout section) {

        header.setOnClickListener(v -> {
            if (section.getVisibility() == View.GONE) {
                section.setVisibility(View.VISIBLE);
                header.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, expandLess, null);
            } else {
                section.setVisibility(View.GONE);
                header.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, expandMore, null);
            }
        });
    }
}
