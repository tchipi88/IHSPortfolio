package com.ihs.appli.portfolio.ui.fragment;

import android.view.View;

import com.ihs.appli.portfolio.R;
import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;

import butterknife.OnClick;

public class SiteAddFragment extends SiteFormFragment{

    @OnClick(R.id.save)
    public void save(View view) {
        if (!validate()) {
            return;
        }

    }
}