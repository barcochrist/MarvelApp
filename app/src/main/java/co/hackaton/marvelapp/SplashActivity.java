package co.hackaton.marvelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import co.hackaton.marvelapp.presentation.presenter.CharacterListContract;
import co.hackaton.marvelapp.presentation.presenter.CharacterListPresenter;

public class SplashActivity extends AppCompatActivity implements CharacterListContract.View{

    private static final String TAG = SplashActivity.class.getSimpleName();
    private CharacterListContract.UserActionListener userActionListener ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        userActionListener = new CharacterListPresenter(this);

       // userActionListener.getList();
    }

    @Override
    public void viewList(List<Character> result) {
        Log.d(TAG, result.toString());
    }

    @Override
    public void showErrorMessage(Exception error) {
        Toast toast = Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
