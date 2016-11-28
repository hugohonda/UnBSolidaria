package br.unb.unbsolidaria;

/**
 * Created by cristian on 15/11/2016.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import br.unb.unbsolidaria.persistency.Database;
import br.unb.unbsolidaria.entities.Opportunity;

public class FakeDB {
    Database BDinterface;

    @Test
    public void TesteUsoBancoDados (){
        List<Opportunity> op_list;
        Opportunity op1;

        op_list = BDinterface.getOpportunities();

        op1 = op_list.get(0);

        //oportunidade.print()
        System.out.println("Opportunity ID #" + op1.getID());
        System.out.println("\t" + op1.getTitle());
        System.out.println("\t" + op1.getLocal());
        System.out.println("\t" + op1.getDescription());
        System.out.println("\t" + op1.getOrganization().getCommercialName());


        System.out.println("Verificadas " + 1 + " (uma) oportunidade do banco de dados");
    }

    @Before
    public void Setup(){
        BDinterface = Database.getInstance();
    }
}
