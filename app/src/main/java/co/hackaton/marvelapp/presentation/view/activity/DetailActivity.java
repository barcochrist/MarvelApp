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

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewDetail;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewDescription = findViewById(R.id.textViewDescription);

        //Obtiene el objeto Character enviado de la actividad anterior
        Intent intent = getIntent();
        Character character = (Character) intent.getSerializableExtra("CHARACTER");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(character.getName());
        setSupportActionBar(toolbar);

        showDataCharacter(character);
    }

    /**
     * Muestra los datos del Character seleccionado.
     *
     * @param character
     */
    private void showDataCharacter(Character character) {
        textViewDescription.setText(character.getDescription());
        Picasso.with(this)
                .load(character.getThumbnail())
                .resize(400, 400)
                .centerCrop()
                .into(imageViewDetail);
    }
}
