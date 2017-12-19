package co.hackaton.marvelapp.domain.usecase;

import java.util.List;

import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 14/12/17.
 */

public interface ShowCharacterList {

    void getList(Callback<List<Character>> callback);
}
