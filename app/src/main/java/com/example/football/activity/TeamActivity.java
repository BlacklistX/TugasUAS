package com.example.football.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.football.R;
import com.squareup.picasso.Picasso;

public class TeamActivity extends AppCompatActivity {
    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @BindView(R.id.tvNama)
    TextView tvNama;

    @BindView(R.id.tvKeterangan)
    TextView tvKeterangan;

    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_team);
        ButterKnife.bind(this);

        Bundle mBundle = getIntent().getExtras();
        tvNama.setText(mBundle.getString("nama"));
        tvKeterangan.setText(mBundle.getString("keterangan"));

        Picasso.get().load(mBundle.getString("logo")).resize(100,100)
                .into(ivLogo);
    }
}