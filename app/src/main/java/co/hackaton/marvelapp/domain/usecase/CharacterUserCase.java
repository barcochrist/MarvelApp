package co.hackaton.marvelapp.domain.usecase;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by christianbarco on 23/12/17.
 */

public interface CharacterUserCase {

    void getAll(Callback<List<Character>> callback);

    void getByID(Integer id, Callback<Character> callback);
}
