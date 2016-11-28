package br.unb.unbsolidaria.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.unb.unbsolidaria.adapter.OpportunitiesAdapter;
import br.unb.unbsolidaria.OpportunitiesListActivity;
import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.entities.Opportunity;

/**
 * Created by Scartezini on 24/11/2016.
 */

public class OpportunitiesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Opportunity> mList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opportunities, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();


                OpportunitiesAdapter adapter = (OpportunitiesAdapter) mRecyclerView.getAdapter();

                if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {

                    List<Opportunity> listAux = ((OpportunitiesListActivity) getActivity()).getSetOportinidadesList(3);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);


        mList = ((OpportunitiesListActivity) getActivity()).getSetOportinidadesList(3);
        OpportunitiesAdapter adapter = new OpportunitiesAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);


        return view;
    }


}
