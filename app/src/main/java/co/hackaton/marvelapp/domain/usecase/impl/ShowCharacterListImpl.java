package co.hackaton.marvelapp.domain.usecase.impl;

import java.util.List;

import co.hackaton.marvelapp.domain.usecase.ShowCharacterList;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.helpers.ThreadExecutor;
import co.hackaton.marvelapp.repository.CharacterRepository;
import co.hackaton.marvelapp.repository.impl.CharacterRepoImpl;

/**
 * Created by casa on 16/12/17.
 */

public class ShowCharacterListImpl implements ShowCharacterList {

    private CharacterRepository characterRepository;

    public ShowCharacterListImpl() {
        this.characterRepository = new CharacterRepoImpl();
    }

    @Override
    public void getList(final Callback<List<Character>> callback) {

        new ThreadExecutor<List<Character>>(new ThreadExecutor.Task<List<Character>>() {
            @Override
            public List<Character> execute() throws Exception {
                return characterRepository.characterList();
            }

            @Override
            public void finish(Exception error, List<Character> result) {
                if(error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();

    }
}
