package br.unb.unbsolidaria;

/**
 * Created by cristian on 15/11/2016.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.unb.unbsolidaria.persistencia.BancoDeDados;
import br.unb.unbsolidaria.entidades.Oportunidade;

import static org.junit.Assert.*;

public class BancoDadosFake {
    BancoDeDados BDinterface;

    @Test
    public void TesteUsoBancoDados (){
        List<Oportunidade> op_list;
        Oportunidade op1;

        op_list = BDinterface.getOportunidades();

        op1 = op_list.get(0);

        //oportunidade.print()
        System.out.println("Oportunidade ID #" + op1.getID());
        System.out.println("\t" + op1.getTitulo());
        System.out.println("\t" + op1.getLocal());
        System.out.println("\t" + op1.getDescricao());
        System.out.println("\t" + op1.getOrg().getNomeComercial());


        System.out.println("Verificadas " + 1 + " (uma) oportunidade do banco de dados");
    }

    @Before
    public void Setup(){
        BDinterface = BancoDeDados.getInstance();
    }
}
