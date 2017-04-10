package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Summoners;




@Service
public interface LeagueRunesService {
	public List<LeagueRunes> getAll();
	public LeagueRunes addAll();
	public LeagueRunes addLeagueRunes(LeagueRunes LeagueRunes);
	public LeagueRunes findLeagueRunes(int id);
	public List<LeagueRunes> findByNameIgnoreCaseContaining(String data);
	public LeagueRunes findByRuneid(int id);
	
} 
