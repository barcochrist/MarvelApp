package co.hackaton.marvelapp.presentation.presenter;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.domain.usecase.ComicUserCase;
import co.hackaton.marvelapp.domain.usecase.impl.ComicUserCaseImpl;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by christianbarco on 24/12/17.
 */

public class ComicListPresenter implements ComicListContract.UserActionListener {

    private ComicListContract.View view;
    private ComicUserCase comicUserCase;
    private List<Comic> list;

    public ComicListPresenter(ComicListContract.View view) {
        this.view = view;
        this.list = new ArrayList<>(0);
        this.comicUserCase = new ComicUserCaseImpl();
    }

    @Override
    public void loadComics() {
        comicUserCase.getAll(new Callback<List<Comic>>() {
            @Override
            public void success(List<Comic> result) {
                list.clear();
                if (list != null) {
                    list.addAll(result);
                    view.refreshComics();
                }
            }

            @Override
            public void error(Exception error) {

            }
        });
    }

    @Override
    public List<Comic> getAllComics() {
        return list;
    }
}
