package br.unb.unbsolidaria;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.unb.unbsolidaria.entities.Opportunity;

/**
 * Created by hugohonda on 21/11/16.
 */

public class OpportunitiesListAdapter extends RecyclerView.Adapter<OpportunitiesListAdapter.ListaOportunidadeViewHolder> {
    private List<Opportunity> opportunityList;

    public OpportunitiesListAdapter(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    @Override
    public ListaOportunidadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_opportunity, parent, false);
        return new ListaOportunidadeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListaOportunidadeViewHolder holder, int position) {
        Opportunity opportunity = opportunityList.get(position);
        holder.title.setText(opportunity.getTitle());
        holder.data.setText(opportunity.getStartDate().toString() + " - " + opportunity.getEndDate().toString());
        holder.organization.setText(opportunity.getOrganization().getCommercialName());
    }

    @Override
    public int getItemCount() {
        return opportunityList.size();
    }

    public static class ListaOportunidadeViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView data;
        public TextView organization;

        public ListaOportunidadeViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_title);
            data = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_data);
            organization = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_organization);
        }
    }
}