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
import co.hackaton.marvelapp.presentation.presenter.MovieListContract;
import co.hackaton.marvelapp.presentation.presenter.MovieListPresenter;
import co.hackaton.marvelapp.presentation.view.adapter.MovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesFragment extends Fragment implements MovieListContract.View {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerViewMovies;
    private MovieListContract.UserActionListener userActionListener;
    private MovieAdapter movieAdapter;

    public MoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SeriesFragment.
     */
    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerViewMovies = view.findViewById(R.id.recyclerViewMovies);

        //Inicialización de presenter
        userActionListener = new MovieListPresenter(this);
        userActionListener.loadMovies();

        //Inicializa el RecyclerView y carga los datos
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewMovies.setLayoutManager(gaggeredGridLayoutManager);
        recyclerViewMovies.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMovies.setHasFixedSize(true);

        movieAdapter = new MovieAdapter(userActionListener.getAllMovies());
        recyclerViewMovies.setAdapter(movieAdapter);
        return view;
    }

    public MovieAdapter getMovieAdapter() {
        return movieAdapter;
    }

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
    public void refreshMovies() {
        recyclerViewMovies.getAdapter().notifyDataSetChanged();
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
