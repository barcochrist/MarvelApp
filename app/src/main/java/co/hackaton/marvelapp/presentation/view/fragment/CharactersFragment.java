package co.hackaton.marvelapp.presentation.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.presentation.view.adapter.CharacterAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharactersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharactersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerCharacters;

    public CharactersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CharactersFragment.
     */
    public static CharactersFragment newInstance() {
        CharactersFragment fragment = new CharactersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        recyclerCharacters = view.findViewById(R.id.recyclerCharacters);

        String[] testData = new String[]{
                "Character 1", "Character 2", "Character 3", "Character 4", "Character 5", "Character 6",
                "Character 1", "Character 2", "Character 3", "Character 4", "Character 5", "Character 6",
                "Character 1", "Character 2", "Character 3", "Character 4", "Character 5", "Character 6"
        };
        Character character1 = new Character();
        character1.setName("Iron Man");
        character1.setthumbnail("http://www.filmofilia.com/wp-content/uploads/2012/10/Iron-Man-3-100x100.png");

        Character character2 = new Character();
        character2.setName("Wonder Woman");
        character2.setthumbnail("http://nerdreactor.com/wp-content/uploads/2011/01/Wonder-Woman-500x500_c.jpg?15016e");

        Character character3 = new Character();
        character3.setName("Spider Man");
        character3.setthumbnail("https://img.class.posot.es/es_es/2015/02/04/Puzzle-Ultimate-Spider-Man-Juguetes-Puzzles-Marvel-20150204145356.jpg");

        Character character4 = new Character();
        character4.setName("Hulk");
        character4.setthumbnail("http://heroicuniverse.com/wp-content/uploads/2014/12/hulk-500x500.jpg");

        Character character5 = new Character();
        character5.setName("Batman");
        character5.setthumbnail("http://publikart.net/wp-content/uploads/iron-studios-batman-art-scale_1-500x500.jpg");

        Character character6 = new Character();
        character6.setName("Deadpool");
        character6.setthumbnail("http://heroicuniverse.com/wp-content/uploads/2015/04/deadpool-500x500.jpg");

        ArrayList<Character> characters = new ArrayList<>();
        characters.add(character1);
        characters.add(character2);
        characters.add(character3);
        characters.add(character4);
        characters.add(character5);
        characters.add(character6);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerCharacters.setLayoutManager(gridLayoutManager);

        CharacterAdapter adapter = new CharacterAdapter(characters);
        recyclerCharacters.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
