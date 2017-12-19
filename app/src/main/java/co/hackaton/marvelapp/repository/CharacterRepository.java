package co.hackaton.marvelapp.repository;

import java.util.List;

/**
 * Created by casa on 16/12/17.
 */

public interface CharacterRepository {

    Character characterById(int id);

    List<Character> characterList() throws Exception;
}
