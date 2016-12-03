package br.unb.unbsolidaria.communication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aurora on 03/12/16.
 */

//Gerador de servicos para clientes rest usando a API do Retrofit 2
//Referencia: https://futurestud.io/tutorials/retrofit-getting-started-and-android-client
public class RestCommunication {
    //TODO: Definir API com o servidor
    public static final String API_BASE_URL = "http://API-DO-SERVIDOR-A-SER-DEFINIDA.url";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //Seta o converter para converter automaticamente objetos em json e json para objetos usando
    //a API do Gsom
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
