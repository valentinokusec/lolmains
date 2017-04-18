package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.SubsctrictionItem;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



@Service
public interface SubstrictinItemService {
	public List<SubsctrictionItem> getAllSubsctrictionItems();
	public SubsctrictionItem addSubsctrictionItem(SubsctrictionItem SubsctrictionItem);
	public void removeSubsctrictionItem(SubsctrictionItem SubsctrictionItem);
	public SubsctrictionItem findSubsctrictionItem(int id);


		
} 
