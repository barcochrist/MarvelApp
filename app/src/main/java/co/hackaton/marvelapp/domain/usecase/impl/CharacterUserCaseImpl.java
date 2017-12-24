package co.hackaton.marvelapp.domain.usecase.impl;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.domain.usecase.CharacterUserCase;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.repository.CharacterRepository;
import co.hackaton.marvelapp.repository.impl.CharacterFirebaseRepository;

/**
 * Created by christianbarco on 23/12/17.
 */

public class CharacterUserCaseImpl implements CharacterUserCase {

    private CharacterRepository characterRepository;

    public CharacterUserCaseImpl() {
        characterRepository = new CharacterFirebaseRepository();
    }

    @Override
    public void getAll(final Callback<List<Character>> callback) {
        characterRepository.getAll(new Callback<List<Character>>() {
            @Override
            public void success(List<Character> result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void getByID(Integer id, final Callback<Character> callback) {
        characterRepository.getByID(id, new Callback<Character>() {
            @Override
            public void success(Character result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}
