package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Summoners;




@Service
public interface SummonersService {
	public List<Summoners> getAll();
	public Summoners addSummoners(Summoners Summoners);
	public Summoners findSummoners(int id);
	
} 
