package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Subsctriction;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



@Service
public interface SubstrictionService {
	public List<Subsctriction> getAllSubsctrictions();
	public Subsctriction addSubsctriction(Subsctriction Subsctriction);
	public void removeSubsctriction(Subsctriction Subsctriction);
	public Subsctriction findSubsctriction(int id);
	public Page<Subsctriction> findAll(Pageable pageable);
	Page<Subsctriction> findAllByMain(Pageable pageable,Mains main);

		
} 
