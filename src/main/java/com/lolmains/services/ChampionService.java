package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Champion;
import com.lolmains.domains.Mains;



@Service
public interface ChampionService {
	
	public List<Champion> addChampion(String server,String summoner);
	public Champion findChampion(int id);
	
} 
