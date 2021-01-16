package com.example.football.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseNextEvent{

	@SerializedName("events")
	private List<EventsItem> events;

	public List<EventsItem> getEvents(){
		return events;
	}
}