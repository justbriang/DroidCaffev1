package com.example.droidcaffev1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.droidcaffev1.adapters.ReciperAdapter;
import com.example.droidcaffev1.adapters.RecyclerItemClickListener;
import com.example.droidcaffev1.models.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dessert_Frag extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ReciperAdapter reciperAdapter;
    private ItemTouchHelper help;
    private Recipe recipe;

    public Dessert_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_dessert_, container, false);
        recyclerView = view.findViewById(R.id.recipe_recycler);
        initRecycler();
        getData();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                recipe = recipeList.get(position);
                                Intent dintent = new Intent(getActivity(), DonutActivity.class);
                                dintent.putExtra("Dimg", recipe.getImage());
                                Log.e(TAG, "onItemClick: "+recipe.getImage() );
                                dintent.putExtra("Dtitle", recipe.getTitle());
                                dintent.putExtra("Ddescription", recipe.getDescription());


//                                Log.e(TAG, "onItemClick: "+ gitHubUser.getUrl());
                                startActivity(dintent);

                            }
                        }));
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(recipeList, from, to);
                reciperAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                recipeList.remove(viewHolder.getAdapterPosition());
                reciperAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(recyclerView);
        return view;
    }


    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        reciperAdapter = new ReciperAdapter(recipeList, getContext());
        recyclerView.setAdapter(reciperAdapter);
    }

    private void getData() {
        String[] Desserttitle = getResources().getStringArray(R.array.dessert_title);
        String[] Destitle = getResources().getStringArray(R.array.dessert_description);
        TypedArray img = getResources().obtainTypedArray(R.array.dessert_img);
        recipeList.clear();
        for (int i = 0; i < Desserttitle.length; i++) {
            recipeList.add(new Recipe(img.getResourceId(i, 0), Desserttitle[i], Destitle[i]));
        }
        img.recycle();
        reciperAdapter.notifyDataSetChanged();
    }
}
