package com.example.football.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.football.R;
import com.example.football.adapter.LeaguePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static butterknife.ButterKnife.*;

public class DetailLeagueActivity extends AppCompatActivity {
    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @BindView(R.id.tvNama)
    TextView tvNama;

    @BindView(R.id.tvKeterangan)
    TextView tvKeterangan;

    @BindView(R.id.tlPager)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_league);

        ButterKnife.bind(this);

        Bundle mBundle=getIntent().getExtras();
        tvNama.setText(mBundle.getString("nama"));
        tvKeterangan.setText(mBundle.getString("keterangan"));

        Picasso.get().load(mBundle.getString("logo")).resize(100,100)
                .into(ivLogo);

        id=mBundle.getString("id");
        

        //Tab Layout
        tabLayout.addTab(tabLayout.newTab().setText("Next Match"));
        tabLayout.addTab(tabLayout.newTab().setText("Last Match"));
        tabLayout.addTab(tabLayout.newTab().setText("Teams"));

        LeaguePagerAdapter pagerAdapter=new LeaguePagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),id);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}