package com.example.miniguides;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    // Local variables
    private Context context;
    private List<Guide> guide;

    public RecyclerViewAdapter(Context context, List<Guide> guide) {
        this.context = context;
        this.guide = guide;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_guide, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.title_guide.setText(guide.get(position).getTitle());
        holder.icon_guide.setImageResource(guide.get(position).getIcon());
        holder.icon_gotoguide.setImageResource(R.drawable.icon_arrow_forward);

        // Open corresponding guide depending on which guide is clicked
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Intent intentRoutes = new Intent(context, RouteActivity.class);
                        context.startActivity(intentRoutes);
                        break;
                    case 1:
                        Intent intentEmail = new Intent(context, WifiActivity.class);
                        context.startActivity(intentEmail);
                        break;
                    case 2:
                        Intent intentPicture = new Intent(context, PictureActivity.class);
                        context.startActivity(intentPicture);
                        break;
                    case 3:
                        Intent intentMobile = new Intent(context, MobileActivity.class);
                        context.startActivity(intentMobile);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return guide.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Method variables
        TextView title_guide;
        ImageView icon_guide;
        ImageView icon_gotoguide;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            // Initialize the method variables
            title_guide = itemView.findViewById(R.id.title_id);
            icon_guide = itemView.findViewById(R.id.iconCategory_id);
            icon_gotoguide = itemView.findViewById(R.id.iconGotoguide_id);

            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }

}
