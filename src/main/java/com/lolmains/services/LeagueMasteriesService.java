package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueMasteries;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Summoners;




@Service
public interface LeagueMasteriesService {
	public List<LeagueMasteries> getAll();
	public LeagueMasteries addAll();
	public LeagueMasteries addLeagueMasteries(LeagueMasteries LeagueMasteries);
	public LeagueMasteries findLeagueMasteries(int id);
	public List<LeagueMasteries> findByNameIgnoreCaseContaining(String data);

	
} 
