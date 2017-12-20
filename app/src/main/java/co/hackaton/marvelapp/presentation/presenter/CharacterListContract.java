package co.hackaton.marvelapp.presentation.presenter;

import java.util.List;

/**
 * Created by casa on 16/12/17.
 */

public interface CharacterListContract {

    interface View{

        void viewList(List<Character> result);

        void showErrorMessage(Exception error);

    }

    interface UserActionListener{
        void getList();
    }
}
