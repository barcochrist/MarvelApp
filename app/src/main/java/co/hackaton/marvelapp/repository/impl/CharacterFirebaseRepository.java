package co.hackaton.marvelapp.repository.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.helpers.Callback;
import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.repository.CharacterRepository;

/**
 * Created by christianbarco on 23/12/17.
 */

public class CharacterFirebaseRepository implements CharacterRepository {

    private DatabaseReference mDatabase;

    public CharacterFirebaseRepository() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void getByID(Integer id, Callback<Character> callback) {
    }

    @Override
    public void getAll(final Callback<List<Character>> callback) {
        mDatabase.child(Constants.CHARACTERS_KEY_FIREBASE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Character> characters = new ArrayList<>();
                for (DataSnapshot characterDataSnapshot : dataSnapshot.getChildren()) {
                    Character character = characterDataSnapshot.getValue(Character.class);
                    characters.add(character);
                }
                callback.success(characters);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.error(databaseError.toException());
            }
        });
    }
}
