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

public interface OpportunityService {
    @GET("/opportunities")
    Call<List<Opportunity>> getOpportunities();

    @GET("/opportunities")
    Call<List<Opportunity>> getOpprtunitiesByTag(@QueryMap Map<String, String> tags);
}