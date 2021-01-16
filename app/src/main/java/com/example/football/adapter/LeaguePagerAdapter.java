package com.example.football.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.football.fragments.LastEventFragment;
import com.example.football.fragments.NextEventFragment;
import com.example.football.fragments.TeamFragment;

public class LeaguePagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    String idLeague;

    public LeaguePagerAdapter(FragmentManager fm,int tabCount,String idLeague) {
        super(fm);
        this.tabCount=tabCount;
        this.idLeague=idLeague;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NextEventFragment.newInstance(idLeague);
            case 1:
                return LastEventFragment.newInstance(idLeague);
            case 2:
                return TeamFragment.newInstance(idLeague);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
