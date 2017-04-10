package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Guide;




@Service
public interface GuideService {
	public List<Guide> getAllGuide();
	public Guide addMain(Guide guide);
	public Guide findMain(int id);
	public Guide findByName(String name);
	
} 
