package com.example.football.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.football.R;
import com.example.football.httpclient.ApiInterface;
import com.example.football.model.EventsItem;
import com.example.football.model.ResponseLookupTeam;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterLastEvent extends RecyclerView.Adapter<AdapterLastEvent.ViewHolder> {

    Context context;
    List<EventsItem> items;

    ApiInterface apiInterface;

    public AdapterLastEvent(Context context,ApiInterface apiInterface) {
        this.context = context;
        this.items = new ArrayList<>();
        this.apiInterface=apiInterface;
    }

    public void setItems(List<EventsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event,parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvHome.setText(items.get(position).getStrHomeTeam());
        holder.tvAway.setText(items.get(position).getStrAwayTeam());

        holder.tvTanggal.setText(items.get(position).getStrTimestamp());

        if (items.get(position).getIntAwayScore()==null){
            holder.tvScore.setText("0 : 0");
        }else {
            holder.tvScore.setText(items.get(position).getIntHomeScore() + " : " + items.get(position).getIntAwayScore());
        }

        getImageTeam(items.get(position).getIdHomeTeam(),holder.ivHome);
        getImageTeam(items.get(position).getIdAwayTeam(),holder.ivAway);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void getImageTeam(String idTeam, final ImageView imageView){
        Call<ResponseLookupTeam> api=apiInterface.getLookupTeam(idTeam);
        api.enqueue(new Callback<ResponseLookupTeam>() {
            @Override
            public void onResponse(Call<ResponseLookupTeam> call, Response<ResponseLookupTeam> response) {
                if(response.isSuccessful()){
                    Picasso.get().load(response.body().getTeams().get(0).getStrTeamBadge())
                            .resize(100,100)
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(Call<ResponseLookupTeam> call, Throwable t) {

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivHome,ivAway;
        TextView tvHome,tvAway,tvTanggal,tvScore;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           ivHome=itemView.findViewById(R.id.ivHome);
           ivAway=itemView.findViewById(R.id.ivAway);
           tvHome=itemView.findViewById(R.id.tvHome);
           tvAway=itemView.findViewById(R.id.tvAway);
           tvTanggal=itemView.findViewById(R.id.tvTanggal);
           tvScore=itemView.findViewById(R.id.tvScore);

            this.itemView=itemView;
        }
    }
}
