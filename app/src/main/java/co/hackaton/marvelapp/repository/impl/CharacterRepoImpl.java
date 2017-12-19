package co.hackaton.marvelapp.repository.impl;

import java.util.List;

import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.helpers.RetrofitSingleton;
import co.hackaton.marvelapp.repository.CharacterRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by casa on 16/12/17.
 */

public class CharacterRepoImpl implements CharacterRepository {


   public interface CharacterService{
       @GET("characters?limit=2&apikey="+ Constants.API_KEY)
       Call<List<Character>> characterList();

   }

    @Override
    public Character characterById(int id) {
        return null;
    }

    @Override
    public List<Character> characterList()throws Exception {


        Retrofit retrofit = RetrofitSingleton.getInstance();
        CharacterService characterServiceService = retrofit.create(CharacterService.class);
        Call<List<Character>> call = characterServiceService.characterList();

        Response<List<Character>> response = call.execute();

        return response.body();

    }
}
