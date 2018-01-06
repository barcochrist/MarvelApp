package co.hackaton.marvelapp.presentation.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.presentation.presenter.CharacterListContract;
import co.hackaton.marvelapp.presentation.presenter.CharacterListPresenter;
import co.hackaton.marvelapp.presentation.view.adapter.CharacterAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharactersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharactersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersFragment extends Fragment implements CharacterListContract.View {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerCharacters;
    private CharacterListContract.UserActionListener userActionListener;
    private CharacterAdapter characterAdapter;

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

        //Inicialización de presenter
        userActionListener = new CharacterListPresenter(this);
        userActionListener.loadCharacters();

        //Inicializa el RecyclerView y carga los datos
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerCharacters.setLayoutManager(gridLayoutManager);
        recyclerCharacters.setItemAnimator(new DefaultItemAnimator());
        recyclerCharacters.setHasFixedSize(true);

        characterAdapter = new CharacterAdapter(userActionListener.getAllCharacters());
        recyclerCharacters.setAdapter(characterAdapter);
        return view;
    }

    public CharacterAdapter getCharacterAdapter() {
        return characterAdapter;
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

    @Override
    public void refreshCharacters() {
        recyclerCharacters.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(Exception error) {

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
