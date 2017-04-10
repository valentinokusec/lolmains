package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Summoners;
import com.lolmains.forms.CreateUser;
import com.lolmains.domains.Mains;




@Service
public interface SummonerService {
	public List<Summoner> getAll();
	public Summoner addSummoners(Summoner summoner);
	public Summoner addSummoners(CreateUser createUser, List<Champion> ch);
	public Summoner findSummoners(int id);
	public Summoner findByName(String name);
	public Summoner findByMain(Mains main);
	public boolean checkcode(Summoner summoner, String code);
	public Page<Summoner> findByMain(Pageable page, Mains main);
	public int countByMain(Mains main);
	
} 
