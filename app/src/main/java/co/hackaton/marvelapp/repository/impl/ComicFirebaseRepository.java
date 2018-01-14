package co.hackaton.marvelapp.repository.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.repository.ComicRepository;

/**
 * Created by christianbarco on 24/12/17.
 */

public class ComicFirebaseRepository implements ComicRepository {

    private DatabaseReference mDatabase;

    public ComicFirebaseRepository() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void getByID(Integer id, Callback<Comic> callback) {

    }

    @Override
    public void getAll(final Callback<List<Comic>> callback) {
        mDatabase.child(Constants.COMICS_KEY_FIREBASE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Comic> list = new ArrayList<>();
                for (DataSnapshot dataSnapshoi : dataSnapshot.getChildren()) {
                    Comic comic = dataSnapshoi.getValue(Comic.class);
                    list.add(comic);
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
