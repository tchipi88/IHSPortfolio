package com.ihs.appli.portfolio.ui.fragment;

import com.ihs.appli.portfolio.R;
import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;

public class SiteFragment extends ViewModelFragment<SiteViewModel>{
    @Override
    protected Class<SiteViewModel> getViewModel() {
        return SiteViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_site;
    }
}
