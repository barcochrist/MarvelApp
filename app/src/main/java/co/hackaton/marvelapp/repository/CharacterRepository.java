package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 16/12/17.
 */

public interface CharacterRepository {

    void getByID(Integer id, Callback<Character> callback);

    void getAll(Callback<List<Character>> callback);
}
