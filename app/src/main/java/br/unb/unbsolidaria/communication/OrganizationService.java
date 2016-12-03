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

public interface OrganizationService {
    @POST("/organizations")
    Call<Organization> postVoluntary(@Body Organization organization);

    @PUT("/organizations/{id}")
    Call<Organization> putVoluntary(@Body Organization organization, @Path("id") String id);

    Call<Organization> putVoluntary(@Path("id") String id);
    @GET("/organizations")
    Call<List<Organization>> getOrganizations();

    @GET("/organizations")
    Call<List<Organization>> getOrganizationByName(@Query("name") String name);

    @PUT("/organization/{id}")
    Call<Organization> putOrganization(@Path("id") String id);
}
