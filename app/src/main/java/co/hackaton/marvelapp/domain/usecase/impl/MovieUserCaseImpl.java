package co.hackaton.marvelapp.domain.usecase.impl;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.domain.usecase.MovieUserCase;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.repository.MovieRepository;
import co.hackaton.marvelapp.repository.impl.MovieFirebaseRepository;

/**
 * Created by christianbarco on 13/01/18.
 */

public class MovieUserCaseImpl implements MovieUserCase {

    private MovieRepository movieRepository;

    public MovieUserCaseImpl() {
        movieRepository = new MovieFirebaseRepository();
    }

    @Override
    public void getAll(final Callback<List<Movie>> callback) {
        movieRepository.getAll(new Callback<List<Movie>>() {
            @Override
            public void success(List<Movie> result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void getByID(Integer id, Callback<Movie> callback) {

    }
}
