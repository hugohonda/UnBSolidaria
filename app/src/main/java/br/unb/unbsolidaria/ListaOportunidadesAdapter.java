package br.unb.unbsolidaria;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.unb.unbsolidaria.entidades.Oportunidade;

/**
 * Created by hugohonda on 21/11/16.
 */

public class ListaOportunidadesAdapter extends RecyclerView.Adapter<ListaOportunidadesAdapter.ListaOportunidadeViewHolder> {
    private List<Oportunidade> oportunidadeList;

    public static class ListaOportunidadeViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo;
        public TextView data;
        public TextView organizacao;

        public ListaOportunidadeViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_titulo);
            data = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_data);
            organizacao = (TextView) itemView.findViewById(R.id.item_lista_oportunidade_tv_organizacao);
        }
    }

    public ListaOportunidadesAdapter(List<Oportunidade> oportunidadeList) {
        this.oportunidadeList = oportunidadeList;
    }

    @Override
    public ListaOportunidadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oportunidade, parent, false);
        return new ListaOportunidadeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListaOportunidadeViewHolder holder, int position) {
        Oportunidade oportunidade = oportunidadeList.get(position);
        holder.titulo.setText(oportunidade.getTitulo());
        holder.data.setText(oportunidade.getInicio().toString() + " - " + oportunidade.getFim().toString());
        holder.organizacao.setText(oportunidade.getOrg().getNomeComercial());
    }

    @Override
    public int getItemCount() {
        return oportunidadeList.size();
    }
}