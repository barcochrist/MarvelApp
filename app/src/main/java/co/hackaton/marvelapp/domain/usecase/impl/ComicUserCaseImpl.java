package co.hackaton.marvelapp.domain.usecase.impl;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.domain.usecase.ComicUserCase;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.repository.ComicRepository;
import co.hackaton.marvelapp.repository.impl.ComicFirebaseRepository;

/**
 * Created by christianbarco on 25/12/17.
 */

public class ComicUserCaseImpl implements ComicUserCase {

    private ComicRepository comicRepository;

    public ComicUserCaseImpl() {
        comicRepository = new ComicFirebaseRepository();
    }

    @Override
    public void getAll(final Callback<List<Comic>> callback) {
        comicRepository.getAll(new Callback<List<Comic>>() {
            @Override
            public void success(List<Comic> result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });

    }

    @Override
    public void getByID(Integer id, final Callback<Comic> callback) {
        comicRepository.getByID(id, new Callback<Comic>() {
            @Override
            public void success(Comic result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}
