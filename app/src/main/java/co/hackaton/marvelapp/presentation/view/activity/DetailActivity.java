package co.hackaton.marvelapp.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.domain.model.Comic;
import co.hackaton.marvelapp.domain.model.Movie;
import co.hackaton.marvelapp.helpers.Constants;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewDetail;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewDescription = findViewById(R.id.textViewDescription);
        Toolbar toolbar = findViewById(R.id.toolbar);

        Intent intent = getIntent();

        //Obtiene el objeto recibido y muestra la información de acuerdo al tipo de objeto
        if (intent.getSerializableExtra(Constants.CHARACTER_KEY) != null) {
            Character character = (Character) intent.getSerializableExtra(Constants.CHARACTER_KEY);
            toolbar.setTitle(character.getName());
            showData(character);
        } else if (intent.getSerializableExtra(Constants.COMIC_KEY) != null) {
            Comic comic = (Comic) intent.getSerializableExtra(Constants.COMIC_KEY);
            toolbar.setTitle(comic.getTitle());
            showData(comic);
        } else if (intent.getSerializableExtra(Constants.MOVIE_KEY) != null) {
            Movie movie = (Movie) intent.getSerializableExtra(Constants.MOVIE_KEY);
            toolbar.setTitle(movie.getTitle());
            showData(movie);
        }

        setSupportActionBar(toolbar);
    }

    /**
     * Muestra los datos del Character seleccionado.
     *
     * @param object objeto del tipo Character, Comic o Movie
     */
    private void showData(Object object) {
        if (object instanceof Character) {
            Character character = (Character) object;
            textViewDescription.setText(character.getDescription());
            Picasso.with(this)
                    .load(character.getThumbnail())
                    .resize(400, 400)
                    .centerCrop()
                    .into(imageViewDetail);

        } else if (object instanceof Comic) {
            Comic comic = (Comic) object;
            textViewDescription.setText(comic.getDescription());
            Picasso.with(this)
                    .load(comic.getImageCover())
                    .centerCrop()
                    .resize(400, 600)
                    .into(imageViewDetail);
        } else if (object instanceof Movie) {
            Movie movie = (Movie) object;
            textViewDescription.setText(movie.getDescription());
            Picasso.with(this)
                    .load(movie.getImageCover())
                    .centerCrop()
                    .resize(400, 600)
                    .into(imageViewDetail);
        }
    }
}
