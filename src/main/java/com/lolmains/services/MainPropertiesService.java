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
import com.lolmains.domains.MainsProperties;
import com.lolmains.domains.Summoner;



@Service
public interface MainPropertiesService {
	public List<MainsProperties> getAllMains();
	public MainsProperties addMainsProperties(MainsProperties main);
	public MainsProperties findMainsProperties(int id);

	
} 
