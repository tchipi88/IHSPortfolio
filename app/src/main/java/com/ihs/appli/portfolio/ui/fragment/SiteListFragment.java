package com.ihs.appli.portfolio.ui.fragment;

import static android.widget.LinearLayout.VERTICAL;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihs.appli.portfolio.R;
import com.ihs.appli.portfolio.domain.Site;
import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SiteListFragment extends ViewModelFragment<SiteViewModel> implements SearchView.OnQueryTextListener {

    protected RecyclerView recyclerView;
    protected View emptyView;
     SimpleItemRecyclerViewAdapter adapter;


    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }

    @Override
    protected Class<SiteViewModel> getViewModel() {
        return SiteViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_site_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);

        recyclerView = view.findViewById(R.id.enquetes);
        emptyView = view.findViewById(R.id.emptyView);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));

        adapter = new SimpleItemRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.loadSites().observe(getViewLifecycleOwner(), sites -> {
            adapter.addAll(sites);
        });

        view.findViewById(R.id.add_site).setOnClickListener(v -> {
            viewModel.setSite(new Site());
            Navigation.findNavController(v).navigate(R.id.action_siteListFragment_to_siteAddFragment);
        });
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.sitelist, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);

        final SearchView searchViewAndroidActionBar = (SearchView) searchViewItem.getActionView();
        searchViewAndroidActionBar.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }


    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> implements Filterable {

        Context context;
        private List<Site> siteList;
        private List<Site> searchSiteList;


        public SimpleItemRecyclerViewAdapter() {
            siteList = new ArrayList<>();
            searchSiteList = new ArrayList<>();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            context = parent.getContext();
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.viewholder_site
                            , parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = siteList.get(position);
            holder.ihsId.setText(holder.mItem.ihsId);
            holder.name.setText(holder.mItem.name);

            holder.mView.setOnClickListener(v -> {
                viewModel.setSite(holder.mItem);
                Navigation.findNavController(v).navigate(R.id.action_siteListFragment_to_siteFragment);

            });
        }

        @Override
        public int getItemCount() {
            return siteList.size();
        }

        public void addAll(List<Site> sites) {
            siteList.addAll(sites);
            searchSiteList.addAll(sites);
            notifyDataSetChanged();

        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();
                    if (charString.isEmpty()) {
                        siteList = searchSiteList;
                    } else {
                        List<Site> filteredList = new ArrayList<>();
                        for (Site row : searchSiteList) {

                            // name match condition. this might differ depending on your requirement
                            if (
                                    row.name.toLowerCase().contains(charString.toLowerCase())
                                    ||row.ihsId.toLowerCase().contains(charString.toLowerCase())
                                    ||row.operatorId.toLowerCase().contains(charString.toLowerCase())

                            ) {
                                filteredList.add(row);
                            }
                        }

                        siteList = filteredList;

                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = siteList;


                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    siteList = (ArrayList<Site>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            @BindView(R.id.name)
            public TextView name;
            @BindView(R.id.ihsId)
            public TextView ihsId;

            public Site mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                ButterKnife.bind(this, itemView);

            }

            @Override
            public String toString() {
                return super.toString() + " '" + name.getText() + "'";
            }
        }
    }


}
