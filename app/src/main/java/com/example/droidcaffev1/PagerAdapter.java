package com.example.droidcaffev1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int tabNos;
    public PagerAdapter(@NonNull FragmentManager fm,int tabNos) {
        super(fm, tabNos);
        this.tabNos=tabNos;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Dessert_Frag();
            case 1:
                return new Pastries_Frag();
            case 2:
                return new Stores_Frag();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabNos;
    }
}
