package co.hackaton.marvelapp.domain.usecase;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by christianbarco on 25/12/17.
 */

public interface ComicUserCase {

    void getAll(Callback<List<Comic>> callback);

    void getByID(Integer id, Callback<Comic> callback);
}
