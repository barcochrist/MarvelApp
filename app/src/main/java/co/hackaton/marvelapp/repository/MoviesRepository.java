package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;

/**
 * Created by casa on 16/12/17.
 */

public interface MoviesRepository {

    Movie seriesById(int id);

    List<Movie> seriesList();
}
