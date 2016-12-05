package br.unb.unbsolidaria.organization;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.adapter.OpportunitiesAdapter;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.persistency.Database;

/**
 * Created by criss on 04/12/2016.
 */

public class ViewOpportunities extends Fragment {

    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Opportunity> mList;

    public ViewOpportunities() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.activity_opportunities_list, container, false);

        mRecyclerView = (RecyclerView) parentView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Database bd = Database.getInstance();
        mList = bd.getOpportunitiesList();

        mAdapter = new OpportunitiesAdapter(getActivity(), mList, null);
        mRecyclerView.setAdapter(mAdapter);

        return parentView;
    }

}
