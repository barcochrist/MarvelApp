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
import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.helpers.Constants;
import co.hackaton.marvelapp.presentation.view.activity.DetailActivity;

/**
 * Created by christianbarco on 24/12/17.
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> implements Filterable {
    private List<Comic> allComics;
    private List<Comic> filterComics;
    private ComicAdapter.ComicFilter comicFilter;

    public ComicAdapter(List<Comic> allComics) {
        this.allComics = allComics;
        this.filterComics = allComics;
        comicFilter = new ComicFilter(ComicAdapter.this);
    }

    @Override
    public ComicAdapter.ComicViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_comic_item, parent, false);
        return new ComicAdapter.ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicAdapter.ComicViewHolder holder, int position) {
        Comic comic = filterComics.get(position);
        holder.bindComic(comic);
    }

    @Override
    public int getItemCount() {
        return filterComics.size();
    }

    @Override
    public Filter getFilter() {
        return comicFilter;
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public ImageView imageViewComic;
        private Comic comic;

        public ComicViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewComic = itemView.findViewById(R.id.imageViewComic);
            itemView.setOnClickListener(this);
        }

        /**
         * Asigna los datos a los componentes visuales del Layout.
         *
         * @param comic objeto del tipo recibido por el adapter.
         */
        public void bindComic(Comic comic) {
            this.comic = comic;
            textViewName.setText(comic.getTitle());
            Picasso.with(this.itemView.getContext())
                    .load(comic.getImageCover())
                    .resize(250, 400)
                    .into(imageViewComic);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.COMIC_KEY, comic);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    public class ComicFilter extends Filter {
        private ComicAdapter mAdapter;

        private ComicFilter(ComicAdapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            if (charString.isEmpty()) {
                filterComics = allComics;
            } else {
                ArrayList<Comic> filteredList = new ArrayList<>();
                for (Comic comic : filterComics) {
                    if (comic.getTitle().toLowerCase().startsWith(charString)) {
                        filteredList.add(comic);
                    }
                }
                filterComics = filteredList;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterComics;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterComics = (List<Comic>) results.values;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
