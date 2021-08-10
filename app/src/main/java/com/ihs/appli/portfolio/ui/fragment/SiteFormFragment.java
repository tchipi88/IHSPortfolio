package com.ihs.appli.portfolio.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ihs.appli.portfolio.R;
import com.ihs.appli.portfolio.domain.enumeration.SiteConfiguration;
import com.ihs.appli.portfolio.domain.enumeration.SiteLocation;
import com.ihs.appli.portfolio.domain.enumeration.SiteTopology;
import com.ihs.appli.portfolio.domain.enumeration.SiteType;
import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;

import butterknife.BindView;

public abstract class SiteFormFragment extends ViewModelFragment<SiteViewModel>{

    @Override
    protected Class<SiteViewModel> getViewModel() {
        return SiteViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_site_form;
    }


    @BindView(R.id.configuration)
    AutoCompleteTextView site_configuration;
    @BindView(R.id.type)
    AutoCompleteTextView site_type;
    @BindView(R.id.region)
    AutoCompleteTextView site_region;
    @BindView(R.id.topology)
    AutoCompleteTextView site_topology;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        ArrayAdapter<SiteLocation> site_location_adapter = new ArrayAdapter<SiteLocation>
                (getContext(), android.R.layout.select_dialog_item, SiteLocation.values());
        site_region.setThreshold(2);
        site_region.setAdapter(site_location_adapter);

        ArrayAdapter<SiteConfiguration> site_configuration_adapter = new ArrayAdapter<SiteConfiguration>
                (getContext(), android.R.layout.select_dialog_item, SiteConfiguration.values());
        site_configuration.setThreshold(1);
        site_configuration.setAdapter(site_configuration_adapter);

        ArrayAdapter<SiteTopology> site_topology_adapter = new ArrayAdapter<SiteTopology>
                (getContext(), android.R.layout.select_dialog_item, SiteTopology.values());
        site_topology.setThreshold(2);
        site_topology.setAdapter(site_topology_adapter);

        ArrayAdapter<SiteType> site_type_adapter = new ArrayAdapter<SiteType>
                (getContext(), android.R.layout.select_dialog_item, SiteType.values());
        site_type.setThreshold(1);
        site_type.setAdapter(site_type_adapter);

        return view;
    }
}
