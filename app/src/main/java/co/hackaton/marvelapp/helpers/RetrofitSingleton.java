package co.hackaton.marvelapp.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by casa on 16/12/17.
 */

public class RetrofitSingleton {

    private static Retrofit retrofit ;


    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = getInstance("https://gateway.marvel.com/");
        }

        return retrofit;
    }

    public static Retrofit getInstance(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
