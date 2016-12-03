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

//Servico cliente REST que implementa requests para a entidade Voluntary
public interface VoluntaryService {
    //Post de um voluntario
    @POST("/voluntaries")
    Call<Voluntary> postVoluntary(@Body Voluntary voluntary);

    //Put de um voluntario com um id especifico
    @PUT("/voluntaries/{id}")
    Call<Voluntary> putVoluntary(@Body Voluntary voluntary, @Path("id") String id);
}
