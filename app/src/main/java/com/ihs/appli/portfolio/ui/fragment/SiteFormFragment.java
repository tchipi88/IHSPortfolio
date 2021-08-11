package com.ihs.appli.portfolio.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

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


        viewModel.getSite().observe(getViewLifecycleOwner(),site -> {

            ((TextView)view.findViewById(R.id.ihsId)).setText(site.ihsId);
            ((TextView)view.findViewById(R.id.region)).setText(site.region);
            ((TextView)view.findViewById(R.id.cluster)).setText(site.cluster);
            ((TextView)view.findViewById(R.id.operatorId)).setText(site.operatorId);
            ((TextView)view.findViewById(R.id.name)).setText(site.name);
            ((TextView)view.findViewById(R.id.topology)).setText(site.topology);
            ((TextView)view.findViewById(R.id.type)).setText(site.type);
            ((TextView)view.findViewById(R.id.configuration)).setText(site.configuration);

            //site management
            ((TextView)view.findViewById(R.id.sbc)).setText(site.sbc);
            ((TextView)view.findViewById(R.id.supervisor)).setText(site.supervisor);
            ((TextView)view.findViewById(R.id.supervisorContact1)).setText(site.supervisorContact1);
            ((TextView)view.findViewById(R.id.supervisorContact2)).setText(site.supervisorContact2);
            ((TextView)view.findViewById(R.id.teamLeader)).setText(site.teamLeader);
            ((TextView)view.findViewById(R.id.teamLeaderContact1)).setText(site.teamLeaderContact1);
            ((TextView)view.findViewById(R.id.teamLeaderContact2)).setText(site.teamLeaderContact2);
            ((TextView)view.findViewById(R.id.securityCompany)).setText(site.securityCompany);
            ((TextView)view.findViewById(R.id.securityCompanyContact)).setText(site.securityCompanyContact);

            //grid information
            //TODO ((TextView)view.findViewById(R.id.transformerAvailable)).setText(site.transformerAvailable!=null?site.transformerAvailable.toString():Boolean.FALSE.toString());
            ((TextView)view.findViewById(R.id.typeConnexion)).setText(site.typeConnexion);
            ((TextView)view.findViewById(R.id.panelNumber)).setText(site.panelNumber);
            ((TextView)view.findViewById(R.id.avrSize)).setText(site.avrSize);

            //power cabinet
            ((TextView)view.findViewById(R.id.rectifierType)).setText(site.rectifierType);
            ((TextView)view.findViewById(R.id.powerCabinetType)).setText(site.powerCabinetType);
            ((TextView)view.findViewById(R.id.batteryType)).setText(site.batteryType);
            ((TextView)view.findViewById(R.id.numberOfRack)).setText(""+site.numberOfRack);
            ((TextView)view.findViewById(R.id.rackCapacity)).setText(""+site.rackCapacity);
            ((TextView)view.findViewById(R.id.currentDCLoad)).setText(site.currentDCLoad!=null?site.currentDCLoad.toString():"");
            ((TextView)view.findViewById(R.id.numberOfRectifierModule)).setText(""+site.numberOfRectifierModule);
            ((TextView)view.findViewById(R.id.numberOfSlotAvailable)).setText(""+site.numberOfSlotAvailable);


            //generator
            ((TextView)view.findViewById(R.id.numberOfGenerator)).setText(""+site.numberOfGenerator);
            ((TextView)view.findViewById(R.id.generatorSize1)).setText(""+site.generatorSize1);
            ((TextView)view.findViewById(R.id.generatorSize2)).setText(""+site.generatorSize2);
            ((TextView)view.findViewById(R.id.generatorBrand)).setText(site.generatorBrand);
            ((TextView)view.findViewById(R.id.generatorEngineBrand)).setText(site.generatorEngineBrand);
            ((TextView)view.findViewById(R.id.generatorEngineType)).setText(site.generatorEngineType);
            ((TextView)view.findViewById(R.id.generatorMainAlternatorBrand)).setText(site.generatorMainAlternatorBrand);
            ((TextView)view.findViewById(R.id.generatorMainAlternatorType)).setText(site.generatorMainAlternatorType);

            //fuel tank
            ((TextView)view.findViewById(R.id.fuelTankForme)).setText(site.fuelTankForme);
            ((TextView)view.findViewById(R.id.fuelTankSize)).setText(site.fuelTankSize);
            ((TextView)view.findViewById(R.id.fuelTankCapacity)).setText(site.fuelTankCapacity);


            //solar system
            ((TextView)view.findViewById(R.id.solarSystemTechnology)).setText(site.solarSystemTechnology);
            ((TextView)view.findViewById(R.id.solarSystemTypeRegulateur)).setText(site.solarSystemTypeRegulateur);
            ((TextView)view.findViewById(R.id.solarSystemQuantityOfModules)).setText(""+site.solarSystemQuantityOfModules);
            ((TextView)view.findViewById(R.id.solarSystemQuantityOfPanels1)).setText(""+site.solarSystemQuantityOfPanels1);
            ((TextView)view.findViewById(R.id.solarSystemQuantityOfPanels2)).setText(""+site.solarSystemQuantityOfPanels2);
            ((TextView)view.findViewById(R.id.solarSystemCaracteristic1)).setText(site.solarSystemCaracteristic1);
            ((TextView)view.findViewById(R.id.solarSystemCaracteristic2)).setText(site.solarSystemCaracteristic2);


        });

        return view;
    }


    public boolean validate() {
        boolean valid = true;

        return valid;
    }
}
