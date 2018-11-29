package de.thro.inf.prg3.a09.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class FighterListAdapter extends ArrayAdapter<Fighter> {

    private final Context context;

    private static class ViewHolder {
        private TextView pilotNameView;
        private TextView fighterTypeView;
        private ImageView fighterImageView;

        ViewHolder(View view) {
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

    public FighterListAdapter(@NonNull Context context) {
        super(context, R.layout.fighter_item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Fighter f = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fighter_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(f == null){
            return convertView;
        }

        viewHolder.setPilot(f.getPilot());
        viewHolder.setFighterType(f.getFighterType());
        viewHolder.setFighterImage(f.getFighterImage());
        return convertView;
    }
}
