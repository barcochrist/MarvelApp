package co.hackaton.marvelapp.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import co.hackaton.marvelapp.R;

/**
 * Created by christianbarco on 17/12/17.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private String[] mDataset;

    public CharacterAdapter(String[] myDataset) {
        mDataset = myDataset;
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
        holder.tv.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv;
        public ImageView imageViewCharacter;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            imageViewCharacter = itemView.findViewById(R.id.imageViewCharacter);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageViewCharacter:
                    Toast.makeText(v.getContext(), "Clicked Country Position", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}