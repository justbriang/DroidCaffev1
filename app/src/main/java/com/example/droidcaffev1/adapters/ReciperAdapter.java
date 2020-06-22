package com.example.droidcaffev1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.droidcaffev1.DonutActivity;
import com.example.droidcaffev1.R;
import com.example.droidcaffev1.models.Recipe;

import java.util.ArrayList;

public class ReciperAdapter extends RecyclerView.Adapter<ReciperAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeData;
    private Context context;

    public ReciperAdapter(ArrayList<Recipe> recipeData, Context context) {
        this.recipeData = recipeData;
        this.context = context;
    }

    @NonNull
    @Override
    public ReciperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recipe_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReciperAdapter.ViewHolder holder, int position) {
        holder.relativeLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));
        Recipe currentRecipe = recipeData.get(position);
        holder.bindTo(currentRecipe);
    }

    @Override
    public int getItemCount() {
        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView recipeImg;
        private TextView title, description;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.recipelay);
            recipeImg = itemView.findViewById(R.id.recipe_imgid);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);


        }

        public void bindTo(Recipe currentRecipe) {
            Glide.with(context).load(currentRecipe.getImage()).into(recipeImg);
            title.setText(currentRecipe.getTitle());
            description.setText(currentRecipe.getDescription());
        }
    }
}
