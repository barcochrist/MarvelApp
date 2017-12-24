package co.hackaton.marvelapp.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.hackaton.marvelapp.R;
import co.hackaton.marvelapp.domain.model.Character;
import co.hackaton.marvelapp.presentation.view.activity.DetailActivity;

/**
 * Created by christianbarco on 17/12/17.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private List<Character> characters;

    public CharacterAdapter(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_character_item, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.bindCharacter(character);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public ImageView imageViewCharacter;
        private Character character;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewCharacter = itemView.findViewById(R.id.imageViewCharacter);
            itemView.setOnClickListener(this);
        }

        public void bindCharacter(Character character) {
            this.character = character;
            textViewName.setText(character.getName());
            Picasso.with(this.itemView.getContext())
                    .load(character.getThumbnail())
                    .resize(200, 200)
                    .into(imageViewCharacter);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("CHARACTER", character);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}