package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Summoners;




@Service
public interface LeagueSummonersService {
	public List<LeagueSummoners> getAll();
	public LeagueSummoners addAll();
	public LeagueSummoners addLeagueSummoners(LeagueSummoners LeagueSummoners);
	public LeagueSummoners findSLeagueSummoners(int id);
	public List<LeagueSummoners> findByNameIgnoreCaseContaining(String data);
	public LeagueSummoners findBySummonersid(long param7);
	
} 
