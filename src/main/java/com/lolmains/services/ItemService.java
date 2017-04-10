package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Item;



@Service
public interface ItemService {
	public List<Item> findByNameIgnoreCaseContaining(String name);
	public List<Item> getAllItems();
	public Item addItem(Item item);
	public Item addAll();
	public Item findItem(int id);
	public Item findByItemId(int id);
	
} 
