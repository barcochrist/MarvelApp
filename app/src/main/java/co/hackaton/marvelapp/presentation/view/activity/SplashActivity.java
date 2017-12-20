package co.hackaton.marvelapp.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.presentation.presenter.CharacterListContract;
import co.hackaton.marvelapp.presentation.presenter.CharacterListPresenter;

public class SplashActivity extends AppCompatActivity implements CharacterListContract.View {

    final String TAG = "response Retrofit";
    private CharacterListContract.UserActionListener userActionListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        userActionListener = new CharacterListPresenter(this);
        userActionListener.getList();
/*
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
        */
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void viewList(List<Character> result) {
        Log.d(TAG,result.toString());
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        startActivity(intent);
    }

    @Override
    public void showErrorMessage(Exception error) {

        Log.d(TAG,error.getMessage());
    }
}
