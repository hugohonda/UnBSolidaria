package br.unb.unbsolidaria.persistencia;

import java.util.Arrays;
import java.util.List;

import br.unb.unbsolidaria.entidades.Oportunidade;
import br.unb.unbsolidaria.entidades.Organizacao;
import br.unb.unbsolidaria.entidades.Tags;
import br.unb.unbsolidaria.entidades.Voluntario;

/**
 * Created by hugohonda on 02/11/16.
 */

public class BancoDeDados {
    private static BancoDeDados instance;
    private List<Voluntario> voluntarios;
    private List<Organizacao> organizacoes;
    private List<Tags> tags;
    private List<Oportunidade> oportunidades;

    private BancoDeDados () {
        voluntarios = Arrays.asList(
                new Voluntario(),
                new Voluntario()
                );
        organizacoes = Arrays.asList(
                new Organizacao(),
                new Organizacao()
                );
        tags = Arrays.asList(
                new Tags(),
                new Tags()
        );
        oportunidades = Arrays.asList(
                new Oportunidade(),
                new Oportunidade()
        );
    }

    public static BancoDeDados getInstance(){
        if(instance == null){
            instance = new BancoDeDados();
        }
        return instance;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public List<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }
}
