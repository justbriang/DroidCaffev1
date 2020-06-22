package com.example.droidcaffev1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.droidcaffev1.R;
import com.example.droidcaffev1.models.Hotel;
import com.example.droidcaffev1.models.Recipe;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private ArrayList<Hotel> hoteldata;
    private Context context;

    public HotelAdapter(ArrayList<Hotel> hoteldata, Context context) {
        this.hoteldata = hoteldata;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotelAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.store_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, int position) {
        Hotel currentHotel = hoteldata.get(position);
        holder.materialCardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in_transistion));
        holder.bindTo(currentHotel);
    }

    @Override
    public int getItemCount() {
        return hoteldata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView hotelimg;
        private CardView materialCardView;
        private TextView htitle, hdescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardView=itemView.findViewById(R.id.card);
            hotelimg = itemView.findViewById(R.id.hotelimg);
            htitle = itemView.findViewById(R.id.hotelname);
            hdescription = itemView.findViewById(R.id.hdescription);


        }

        public void bindTo(Hotel hotel) {
            Glide.with(context).load(hotel.getHimage()).into(hotelimg);
            htitle.setText(hotel.getHtitle());
            hdescription.setText(hotel.getHdescription());
        }
    }
}
