package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;




@Service
public interface  BestOfService {
	public List< BestOf> getAll();
	public  BestOf addBestOf( BestOf  BestOf);
	public  BestOf findBestOf(int id);
	
} 
