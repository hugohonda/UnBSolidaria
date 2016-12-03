package br.unb.unbsolidaria.communication;

import java.util.List;

import br.unb.unbsolidaria.entities.Organization;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aurora on 03/12/16.
 */

//Servico cliente REST que implementa requests para a entidade Organization
public interface OrganizationService {
    //Post de uma organizacao
    @POST("/organizations")
    Call<Organization> postOrganization(@Body Organization organization);

    //Put de uma organizacao
    @PUT("/organizations/{id}")
    Call<Organization> putOrganization(@Body Organization organization, @Path("id") String id);

    //Get lista de organizacoes
    @GET("/organizations")
    Call<List<Organization>> getOrganizations();

    //Get lista de organizacoes por nome
    @GET("/organizations")
    Call<List<Organization>> getOrganizationByName(@Query("name") String name);
}
