package com.example.football.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.football.R;
import com.example.football.activity.DetailLeagueActivity;
import com.example.football.activity.TeamActivity;
import com.example.football.httpclient.ApiInterface;

import com.example.football.model.ResponseLookupTeam;
import com.example.football.model.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.ViewHolder> {
    Context context;
    List<TeamsItem> items;

    ApiInterface apiInterface;

    public AdapterTeam(Context context, ApiInterface apiInterface) {
        this.context = context;
        this.items = new ArrayList<>();
        this.apiInterface=apiInterface;
    }

    public void setItems(List<TeamsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teams,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNama.setText(items.get(position).getStrTeam());

        Picasso.get()
                .load(items.get(position).getStrTeamBadge())
                .resize(100,100)
                .into(holder.ivlogo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, TeamActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("id",items.get(position).getIdLeague());
                mBundle.putString("nama",items.get(position).getStrTeam());
                mBundle.putString("logo",items.get(position).getStrTeamBadge());
                mBundle.putString("keterangan",items.get(position).getStrDescriptionEN());
                intent.putExtras(mBundle);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() { return items.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivlogo;
        TextView tvNama;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivlogo=itemView.findViewById(R.id.ivlogo);
            tvNama=itemView.findViewById(R.id.tvNama);

            this.itemView=itemView;
        }
    }
}