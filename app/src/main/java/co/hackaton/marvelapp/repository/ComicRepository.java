package co.hackaton.marvelapp.repository;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 16/12/17.
 */

public interface ComicRepository {

    void getByID(Integer id, Callback<Comic> callback);

    void getAll(Callback<List<Comic>> callback);
}
