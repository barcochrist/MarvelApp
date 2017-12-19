package co.hackaton.marvelapp.presentation.presenter;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.usecase.ShowCharacterList;
import co.hackaton.marvelapp.domain.usecase.impl.ShowCharacterListImpl;
import co.hackaton.marvelapp.helpers.Callback;

/**
 * Created by casa on 18/12/17.
 */

public class CharacterListPresenter implements CharacterListContract.UserActionListener {

   private CharacterListContract.View view ;
   private ShowCharacterList showCharacterList ;
   private List<Character> listCharacter ;

    public CharacterListPresenter(CharacterListContract.View view) {

        this.view = view;
        this.showCharacterList = new ShowCharacterListImpl();
        this.listCharacter = new ArrayList<>(0);
    }

    @Override
    public List<Character> getList() {

        showCharacterList.getList(new Callback<List<Character>>() {
            @Override
            public void success(List<Character> result) {
                listCharacter.clear();
                if( result != null ){
                    listCharacter.addAll(result);
                    view.viewList(listCharacter);
                }
            }

            @Override
            public void error(Exception error) {
                view.showErrorMessage(error);
            }
        });
        return null;
    }
}
