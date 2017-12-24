package co.hackaton.marvelapp.presentation.presenter;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.domain.usecase.CharacterUserCase;
import co.hackaton.marvelapp.domain.usecase.impl.CharacterUserCaseImpl;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 18/12/17.
 */

public class CharacterListPresenter implements CharacterListContract.UserActionListener {

    private CharacterListContract.View view;
    private CharacterUserCase characterUserCase;
    private List<Character> listCharacter;

    public CharacterListPresenter(CharacterListContract.View view) {
        this.view = view;
        this.listCharacter = new ArrayList<>(0);
        this.characterUserCase = new CharacterUserCaseImpl();
    }

    @Override
    public void loadCharacters() {
        characterUserCase.getAll(new Callback<List<Character>>() {
            @Override
            public void success(List<Character> result) {
                listCharacter.clear();
                if (listCharacter != null) {
                    listCharacter.addAll(result);
                    view.refreshCharacters();
                }
            }

            @Override
            public void error(Exception error) {

            }
        });

    }

    @Override
    public List<Character> getAllCharacters() {
        return listCharacter;
    }
}
