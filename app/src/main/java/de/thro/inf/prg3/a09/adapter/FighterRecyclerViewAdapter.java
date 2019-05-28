package de.thro.inf.prg3.a09.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.model.Fighter;

public class FighterRecyclerViewAdapter  extends RecyclerView.Adapter<FighterRecyclerViewAdapter.ViewHolder> {
    //private final Context context;
    private ArrayList<Fighter> fighters = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView pilotNameView;
        private TextView fighterTypeView;
        private ImageView fighterImageView;

        ViewHolder(View view) {
            super(view);
            pilotNameView = view.findViewById(R.id.pilotNameView);
            fighterTypeView = view.findViewById(R.id.fighterTypeView);
            fighterImageView = view.findViewById(R.id.fighterImageView);
        }

        void setPilot(String pilot){
            pilotNameView.setText(pilot);
        }

        void setFighterType(String fighterType){
            fighterTypeView.setText(fighterType);
        }

        void setFighterImage(Drawable fighterImage){
            fighterImageView.setImageDrawable(fighterImage);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Log.i(FighterRecyclerViewAdapter.class.getName(), "View created");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View convertView = inflater.inflate(R.layout.fighter_item, parent, false);
        ViewHolder viewHolder = new FighterRecyclerViewAdapter.ViewHolder(convertView);
        convertView.setTag(viewHolder);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FighterRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        viewHolder.setFighterImage(fighters.get(position).getFighterImage());
        viewHolder.setPilot(fighters.get(position).getPilot());
        viewHolder.setFighterType(fighters.get(position).getFighterType());
    }

    @Override
    public int getItemCount() {
        return fighters.size();
    }

    public void add(Fighter fighter){
        fighters.add(fighter);
    }
}
