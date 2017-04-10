package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Masteries;




@Service
public interface MasteriesService {
	public List<Masteries> getAll();
	public Masteries addMasteries(Masteries Masteries);
	public Masteries findMasteries(int id);
	
} 
