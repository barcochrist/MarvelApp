package co.hackaton.marvelapp.presentation.presenter;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.domain.usecase.MovieUserCase;
import co.hackaton.marvelapp.domain.usecase.impl.MovieUserCaseImpl;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by christianbarco on 13/01/18.
 */

public class MovieListPresenter implements MovieListContract.UserActionListener {

    private MovieListContract.View view;
    private MovieUserCase movieUserCase;
    private List<Movie> list;

    public MovieListPresenter(MovieListContract.View view) {
        this.view = view;
        this.list = new ArrayList<>(0);
        this.movieUserCase = new MovieUserCaseImpl();
    }

    @Override
    public void loadMovies() {
        movieUserCase.getAll(new Callback<List<Movie>>() {
            @Override
            public void success(List<Movie> result) {
                list.clear();
                if (list != null) {
                    list.addAll(result);
                    view.refreshMovies();
                }
            }

            @Override
            public void error(Exception error) {
                view.showErrorMessage(error);
            }
        });
    }

    @Override
    public List<Movie> getAllMovies() {
        return list;
    }
}
