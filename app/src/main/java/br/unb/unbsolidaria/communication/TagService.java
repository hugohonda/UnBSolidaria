package br.unb.unbsolidaria.communication;

import java.util.List;

import br.unb.unbsolidaria.entities.Tag;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aurora on 03/12/16.
 */

//Servico cliente REST que implementa requests para a entidade Tag
public interface TagService {
    //Get lista de tags
    @GET("/tags")
    Call<List<Tag>> getTags();
}
