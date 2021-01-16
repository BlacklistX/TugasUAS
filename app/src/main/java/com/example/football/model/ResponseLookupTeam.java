package com.example.football.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLookupTeam{

	@SerializedName("teams")
	private List<TeamsItem> teams;

	public List<TeamsItem> getTeams(){
		return teams;
	}
}