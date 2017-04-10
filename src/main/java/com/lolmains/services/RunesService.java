package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Runes;




@Service
public interface RunesService {
	public List<Runes> getAll();
	public Runes addRunes(Runes Runes);
	public Runes findRunes(int id);
	
} 
