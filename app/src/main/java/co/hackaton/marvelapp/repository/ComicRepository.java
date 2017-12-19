package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;

/**
 * Created by casa on 16/12/17.
 */

public interface ComicRepository {

    Comic comicById(int id);

    List<Comic> comicList();
}
