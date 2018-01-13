package co.hackaton.marvelapp.presentation.presenter;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;

/**
 * Created by christianbarco on 13/01/18.
 */

public interface MovieListContract {

    interface View {

        void refreshMovies();

        void showErrorMessage(Exception error);

    }

    interface UserActionListener {
        void loadMovies();

        List<Movie> getAllMovies();
    }
}
