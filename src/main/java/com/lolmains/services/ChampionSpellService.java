package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Guide;




@Service
public interface ChampionSpellService {
	public List<ChampionSpells> getAll();
	public ChampionSpells addChampionSpells(ChampionSpells ChampionSpells);
	public ChampionSpells findChampionSpells(int id);
	public List<ChampionSpells> findByNameIgnoreCaseContaining(String name);
	
} 
