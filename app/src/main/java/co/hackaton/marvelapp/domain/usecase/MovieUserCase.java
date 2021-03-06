package co.hackaton.marvelapp.domain.usecase;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 14/12/17.
 */

public interface MovieUserCase {

    void getAll(Callback<List<Movie>> callback);

    void getByID(Integer id, Callback<Movie> callback);
}
