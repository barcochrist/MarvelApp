package co.hackaton.marvelapp.presentation.presenter;

import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;

/**
 * Created by christianbarco on 24/12/17.
 */

public interface ComicListContract {
    interface View {

        void refreshComics();

        void showErrorMessage(Exception error);

    }

    interface UserActionListener {
        void loadComics();

        List<Comic> getAllComics();
    }
}
