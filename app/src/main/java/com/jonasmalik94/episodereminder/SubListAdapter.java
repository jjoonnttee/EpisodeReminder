package com.jonasmalik94.episodereminder;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonas on 2016-06-22.
 */
public class SubListAdapter extends ArrayAdapter<SubListRow> {
    public SubListAdapter(Context context, ArrayList<SubListRow> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        SubListRow row = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_sub, parent, false);
        }

        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.sub_title);
        TextView season = (TextView) convertView.findViewById(R.id.season);
        TextView episode = (TextView) convertView.findViewById(R.id.episode);
        FloatingActionButton rating = (FloatingActionButton) convertView.findViewById(R.id.sub_rating);

        // Populate the data into the template view using the data object
        title.setText(row.getTitle());
        season.setText(row.getSeason());
        episode.setText(row.getEpisode());
        if (row.getRating().equals("0")){
            rating.setImageResource(android.R.drawable.btn_star_big_off);
        }else {
            rating.setImageResource(android.R.drawable.btn_star_big_on);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}