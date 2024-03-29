package com.ihs.appli.portfolio.ui.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ihs.appli.portfolio.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SiteViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    @BindView(R.id.name)
    public TextView name;
    @BindView(R.id.ihsId)
    public TextView ihsId;
    @BindView(R.id.operatorId)
    public TextView site_operator_id;
    @BindView(R.id.region)
    public TextView site_location;
    @BindView(R.id.configuration)
    public TextView site_configuration;
    @BindView(R.id.type)
    public TextView site_classe;
    @BindView(R.id.topology)
    public TextView site_topology;

    public SiteViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        ButterKnife.bind(this, itemView);
    }

}