package com.example.droidcaffev1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.droidcaffev1.adapters.HotelAdapter;

import com.example.droidcaffev1.adapters.RecyclerItemClickListener;
import com.example.droidcaffev1.models.Hotel;


import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class Stores_Frag extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Hotel> hotellist = new ArrayList<>();
    private HotelAdapter hotelAdapter;
    private ItemTouchHelper help;
    private Hotel hotel;
    public Stores_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_stores_, container, false);
        recyclerView = view.findViewById(R.id.hrecipe_recycler);
        initRecycler();
        getData();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(),
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                hotel = hotellist.get(position);
                                Intent dintent = new Intent(getActivity(), DonutActivity.class);
                                dintent.putExtra("Dimg", hotel.getHimage());
                                dintent.putExtra("Dtitle", hotel.getHtitle());
                                dintent.putExtra("Ddescription", hotel.getHdescription());


//                                Log.e(TAG, "onItemClick: "+ gitHubUser.getUrl());
                                startActivity(dintent);

                            }
                        }));
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(hotellist, from, to);
                hotelAdapter.notifyItemMoved(from, to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                hotellist.remove(viewHolder.getAdapterPosition());
                hotelAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(recyclerView);
        return view;
    }
    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        hotelAdapter = new HotelAdapter(hotellist, getContext());
        recyclerView.setAdapter(hotelAdapter);
    }

    private void getData() {
        String[] hotelname = getResources().getStringArray(R.array.hotelname);
        String[] hoteldes = getResources().getStringArray(R.array.hoteldescription);
        TypedArray hotelimg = getResources().obtainTypedArray(R.array.hotels);
        hotellist.clear();
        for (int i = 0; i < hotelname.length; i++) {
            hotellist.add(new Hotel(hotelimg.getResourceId(i, 0), hotelname[i], hoteldes[i]));
        }
        hotelimg.recycle();
        hotelAdapter.notifyDataSetChanged();
    }
}
