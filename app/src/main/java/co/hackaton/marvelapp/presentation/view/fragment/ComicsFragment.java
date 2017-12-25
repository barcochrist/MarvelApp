package co.hackaton.marvelapp.presentation.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.presentation.presenter.ComicListContract;
import co.hackaton.marvelapp.presentation.presenter.ComicListPresenter;
import co.hackaton.marvelapp.presentation.view.adapter.ComicAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComicsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComicsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComicsFragment extends Fragment implements ComicListContract.View {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerViewComics;
    private ComicListContract.UserActionListener userActionListener;


    public ComicsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ComicsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComicsFragment newInstance() {
        ComicsFragment fragment = new ComicsFragment();
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
        View view = inflater.inflate(R.layout.fragment_comics, container, false);
        recyclerViewComics = view.findViewById(R.id.recyclerViewComics);

        //Inicialización de presenter
        userActionListener = new ComicListPresenter(this);
        userActionListener.loadComics();

        //Inicializa el RecyclerView y carga los datos
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);


        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewComics.setLayoutManager(gaggeredGridLayoutManager);
        recyclerViewComics.setItemAnimator(new DefaultItemAnimator());
        recyclerViewComics.setHasFixedSize(true);

        ComicAdapter adapter = new ComicAdapter(userActionListener.getAllComics());
        recyclerViewComics.setAdapter(adapter);

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

    @Override
    public void refreshComics() {
        recyclerViewComics.getAdapter().notifyDataSetChanged();
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
