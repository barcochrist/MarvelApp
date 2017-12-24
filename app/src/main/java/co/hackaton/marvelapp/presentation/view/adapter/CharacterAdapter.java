package co.hackaton.marvelapp.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
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
        holder.tv.setText(characters.get(position).getName());
        Picasso.with(holder.itemView.getContext())
                .load(characters.get(position).getThumbnail())
                .resize(200, 200)
                .into(holder.imageViewCharacter);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv;
        public ImageView imageViewCharacter;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            imageViewCharacter = itemView.findViewById(R.id.imageViewCharacter);
            imageViewCharacter.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            switch (v.getId()) {
                case R.id.imageViewCharacter:
                    Intent intent = new Intent(context, DetailActivity.class);
                    context.startActivity(intent);
                    break;
            }
        }
    }
}