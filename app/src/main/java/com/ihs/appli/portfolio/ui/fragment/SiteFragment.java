package com.ihs.appli.portfolio.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.navigation.fragment.NavHostFragment;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.site, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_edit:
                NavHostFragment.findNavController(SiteFragment.this).navigate(R.id.action_siteFragment_to_siteEditFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        collapseExpand(view.findViewById(R.id.header_site_management), view.findViewById(R.id.section_site_management));
        collapseExpand(view.findViewById(R.id.header_site_grid_information), view.findViewById(R.id.section_site_grid_information));
        collapseExpand(view.findViewById(R.id.header_site_power_cabinet_information), view.findViewById(R.id.section_site_power_cabinet_information));
        collapseExpand(view.findViewById(R.id.header_site_generator_information), view.findViewById(R.id.section_site_generator_information));
        collapseExpand(view.findViewById(R.id.header_site_fuel_tank_information), view.findViewById(R.id.section_site_fuel_tank_information));
        collapseExpand(view.findViewById(R.id.header_site_solar_system), view.findViewById(R.id.section_site_solar_system));


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
            ((TextView)view.findViewById(R.id.transformerAvailable)).setText(site.transformerAvailable!=null?site.transformerAvailable.toString():Boolean.FALSE.toString());
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

}
