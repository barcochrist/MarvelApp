package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Series;

/**
 * Created by casa on 16/12/17.
 */

public interface SeriesRepository {

    Series seriesById(int id);

    List<Series> seriesList();
}
