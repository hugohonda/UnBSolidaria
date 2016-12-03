package br.unb.unbsolidaria.communication;

import java.util.List;
import java.util.Map;

import br.unb.unbsolidaria.entities.Opportunity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by aurora on 03/12/16.
 */

//Servico cliente REST que implementa requests para a entidade Opportunity
public interface OpportunityService {
    //Get lista de oportunidades
    @GET("/opportunities")
    Call<List<Opportunity>> getOpportunities();

    //Get lista de oportunidades dado tags
    @GET("/opportunities")
    Call<List<Opportunity>> getOpprtunitiesByTag(@QueryMap Map<String, String> tags);
}