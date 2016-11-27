package br.unb.unbsolidaria.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.unb.unbsolidaria.Adapter.OportunidadesAdapter;
import br.unb.unbsolidaria.ListaOportunidadesActivity;
import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.entidades.Oportunidade;

/**
 * Created by Scartezini on 24/11/2016.
 */

public class OportunidadesFragment  extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Oportunidade> mList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oportunidades, container, false);

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


                OportunidadesAdapter adapter = (OportunidadesAdapter) mRecyclerView.getAdapter();

                if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {

                    List<Oportunidade> listAux = ((ListaOportunidadesActivity) getActivity()).getSetOportinidadesList(3);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);



        mList = ((ListaOportunidadesActivity) getActivity()).getSetOportinidadesList(3);
        OportunidadesAdapter adapter = new OportunidadesAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );


        return view;
    }


}
