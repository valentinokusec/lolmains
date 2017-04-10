package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;



@Service
public interface MainsService {
	public List<Mains> getAllMains();
	public Mains addMain(Mains main);
	public Mains findMain(int id);
	public Mains findByName(String name);
	public Page<Summoner> findBySummoner(Pageable pageable);
	public Page<Guide> findByGuide(Pageable pageable);
	
} 
