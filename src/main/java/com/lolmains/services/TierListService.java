package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.domains.TierList;
import com.lolmains.domains.User;



@Service
public interface TierListService {
	public List<TierList> getAllTopics();
	public TierList addTierList(TierList TierList);
	public TierList findTTierList(int id);
	TierList findAllByMain(Mains main);

	
} 
