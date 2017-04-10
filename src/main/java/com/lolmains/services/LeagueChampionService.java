package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.User;



@Service
public interface LeagueChampionService {
	public List<LeagueChampion> getAllLeagueChampion();
	public LeagueChampion addLeagueChampion(Item LeagueChampion);
	public LeagueChampion addAll();
	public LeagueChampion findLeagueChampion(int id);
	public List<LeagueChampion> findByNameIgnoreCaseContaining(String string);
	public LeagueChampion findByChampionid(Long id);
	
	
} 
