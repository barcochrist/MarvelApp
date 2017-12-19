package co.hackaton.marvelapp.helpers;

/**
 * Created by casa on 14/12/17.
 */

public interface Callback<T> {

    void success(T result);
    void error (Exception error);
}
