package co.hackaton.marvelapp.presentation.presenter;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;

/**
 * Created by casa on 16/12/17.
 */

public interface CharacterListContract {

    interface View {

        void refreshCharacters();

        void showErrorMessage(Exception error);

    }

    interface UserActionListener {
        void loadCharacters();

        List<Character> getAllCharacters();
    }
}
