package com.ihs.appli.portfolio.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.ihs.appli.portfolio.R;
import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;

import butterknife.BindDrawable;

public class SiteFragment extends ViewModelFragment<SiteViewModel>{



    @Override
    protected Class<SiteViewModel> getViewModel() {
        return SiteViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_site;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        collapseExpand(view.findViewById(R.id.header_site_informations), view.findViewById(R.id.section_site_informations));
        collapseExpand(view.findViewById(R.id.header_site_management), view.findViewById(R.id.section_site_management));
        collapseExpand(view.findViewById(R.id.header_site_grid_information), view.findViewById(R.id.section_site_grid_information));
        collapseExpand(view.findViewById(R.id.header_site_power_cabinet_information), view.findViewById(R.id.section_site_power_cabinet_information));
        collapseExpand(view.findViewById(R.id.header_site_generator_information), view.findViewById(R.id.section_site_generator_information));
        collapseExpand(view.findViewById(R.id.header_site_fuel_tank_information), view.findViewById(R.id.section_site_fuel_tank_information));
        collapseExpand(view.findViewById(R.id.header_site_solar_system), view.findViewById(R.id.section_site_solar_system));

        return view;
    }

}
