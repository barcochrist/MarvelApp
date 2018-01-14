package co.hackaton.marvelapp.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.presentation.view.activity.DetailActivity;

/**
 * Created by christianbarco on 13/01/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements Filterable {
    private List<Movie> allMovies;
    private List<Movie> filterMovies;
    private MovieFilter movieFilter;

    public MovieAdapter(List<Movie> allMovies) {
        this.allMovies = allMovies;
        this.filterMovies = allMovies;
        this.movieFilter = new MovieAdapter.MovieFilter(MovieAdapter.this);
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_movie_item, parent, false);
        return new MovieAdapter.MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(filterMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return filterMovies.size();
    }

    @Override
    public Filter getFilter() {
        return movieFilter;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private ImageView imageView;
        private Movie movie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageViewMovie);
            itemView.setOnClickListener(this);
        }

        /**
         * Asigna los datos a los componentes visuales del Layout.
         *
         * @param Movie objeto del tipo recibido por el adapter.
         */
        public void bindMovie(Movie Movie) {
            this.movie = Movie;
            textView.setText(Movie.getTitle());
            Picasso.with(this.itemView.getContext())
                    .load(Movie.getImageCover())
                    .resize(250, 400)
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.MOVIE_KEY, movie);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    public class MovieFilter extends Filter {
        private MovieAdapter mAdapter;

        private MovieFilter(MovieAdapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            if (charString.isEmpty()) {
                filterMovies = allMovies;
            } else {
                ArrayList<Movie> filteredList = new ArrayList<>();
                for (Movie movie : filterMovies) {
                    if (movie.getTitle().toLowerCase().startsWith(charString)) {
                        filteredList.add(movie);
                    }
                }
                filterMovies = filteredList;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterMovies;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterMovies = (List<Movie>) results.values;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
