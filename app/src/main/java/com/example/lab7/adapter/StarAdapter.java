package com.example.lab7.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab7.R;
import com.example.lab7.beans.Star;
import com.example.lab7.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private final List<Star> stars;
    private final List<Star> starsFilter;
    private final Context context;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.stars = stars;
        this.starsFilter = new ArrayList<>(stars);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false);
        return new StarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star s = starsFilter.get(position);

        holder.name.setText(s.getName());
        holder.rating.setRating(s.getRating());

        Glide.with(context).load(s.getImg()).into(holder.img);

        holder.itemView.setOnClickListener(v ->
                showPopup(s, holder.getBindingAdapterPosition()));
    }

    private void showPopup(Star star, int position) {
        View popup = LayoutInflater.from(context).inflate(R.layout.star_edit_item, null);

        RatingBar ratingBar = popup.findViewById(R.id.ratingBar);
        ratingBar.setRating(star.getRating());

        new AlertDialog.Builder(context)
                .setTitle("Modifier note")
                .setView(popup)
                .setPositiveButton("Valider", (d, w) -> {
                    star.setRating(ratingBar.getRating());
                    StarService.getInstance().update(star);
                    notifyItemChanged(position);
                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    @Override
    public int getItemCount() {
        return starsFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Star> filtered = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filtered.addAll(stars);
                } else {
                    String pattern = constraint.toString().toLowerCase().trim();

                    for (Star s : stars) {
                        if (s.getName().toLowerCase().contains(pattern)) {
                            filtered.add(s);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                starsFilter.clear();
                starsFilter.addAll((List<Star>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        RatingBar rating;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgStar);
            name = itemView.findViewById(R.id.tvName);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}