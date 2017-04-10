package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;




@Service
public interface BuildService {
	public List<Build> getAll();
	public Build addBuild(Build Build);
	public Build findBuild(int id);
	
} 
