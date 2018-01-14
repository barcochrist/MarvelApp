package co.hackaton.marvelapp.repository.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.repository.MovieRepository;

/**
 * Created by christianbarco on 13/01/18.
 */

public class MovieFirebaseRepository implements MovieRepository {

    private DatabaseReference mDatabase;

    public MovieFirebaseRepository() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void getByID(Integer id, Callback<Movie> callback) {

    }

    @Override
    public void getAll(final Callback<List<Movie>> callback) {
        mDatabase.child(Constants.MOVIES_KEY_FIREBASE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Movie> list = new ArrayList<>();
                for (DataSnapshot dataSnapshoi : dataSnapshot.getChildren()) {
                    Movie movie = dataSnapshoi.getValue(Movie.class);
                    list.add(movie);
                }
                callback.success(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.error(databaseError.toException());
            }
        });
    }
}
