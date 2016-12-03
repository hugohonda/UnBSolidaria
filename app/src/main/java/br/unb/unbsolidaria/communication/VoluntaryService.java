package br.unb.unbsolidaria.communication;

import br.unb.unbsolidaria.entities.Voluntary;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by aurora on 03/12/16.
 */

public interface VoluntaryService {
    @POST("/voluntaries")
    Call<Voluntary> postVoluntary(@Body Voluntary voluntary);

    @PUT("/voluntaries/{id}")
    Call<Voluntary> putVoluntary(@Body Voluntary voluntary, @Path("id") String id);
}
