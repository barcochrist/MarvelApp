package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 16/12/17.
 */

public interface MovieRepository {

    void getByID(Integer id, Callback<Movie> callback);

    void getAll(Callback<List<Movie>> callback);
}
