package com.example.football.httpclient;

import com.example.football.model.ResponseAllLeague;
import com.example.football.model.ResponseAllTeam;
import com.example.football.model.ResponseDetailLeague;
import com.example.football.model.ResponseLastEvent;
import com.example.football.model.ResponseLookupTeam;
import com.example.football.model.ResponseNextEvent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_all_leagues.php?s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    @GET("lookupleague.php")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id") String id);

    @GET("eventsnextleague.php")
    Call<ResponseNextEvent> getNextEventByLeague(@Query("id") String id);

    @GET("eventspastleague.php")
    Call<ResponseLastEvent> getLastEventByLeague(@Query("id") String id);

    @GET("lookupteam.php")
    Call<ResponseLookupTeam> getLookupTeam(@Query("id") String id);

    @GET("lookup_all_teams.php")
    Call<ResponseAllTeam> getAllTeam(@Query("id") String id);
}
