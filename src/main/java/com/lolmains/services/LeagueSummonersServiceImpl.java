package com.lolmains.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoners;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.LeagueSummonersDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.SummonersDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;



@Service
public class LeagueSummonersServiceImpl implements LeagueSummonersService {
	

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";
	
	
	@Autowired
	 LeagueSummonersDao  leaguesummonersdao;

	@Override
	public List<LeagueSummoners> getAll() {
		// TODO Auto-generated method stub
		return leaguesummonersdao.findAll();
	}

	@Override
	public LeagueSummoners addLeagueSummoners(LeagueSummoners LeagueSummoners) {
		// TODO Auto-generated method stub
		return leaguesummonersdao.save(LeagueSummoners);
	}

	@Override
	public LeagueSummoners findSLeagueSummoners(int id) {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeagueSummoners addAll() {
		// TODO Auto-generated method stub
		
		
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		List<com.robrua.orianna.type.core.staticdata.SummonerSpell> itemList=RiotAPI.getSummonerSpells();
		for (com.robrua.orianna.type.core.staticdata.SummonerSpell summoner:itemList) {
			try {
				LeagueSummoners ls=new LeagueSummoners(2, summoner.getID(),summoner.getDescription(), summoner.getName(),summoner.getImage().getFull());
				leaguesummonersdao.save(ls);
			} catch (Exception e) {
				System.out.println(summoner.getID());
			}
		}
		return null;
	}

	@Override
	public List<LeagueSummoners> findByNameIgnoreCaseContaining(String data) {
		// TODO Auto-generated method stub
		return leaguesummonersdao.findByNameIgnoreCaseContaining(data);
	}

	@Override
	public LeagueSummoners findBySummonersid(long param7) {
		// TODO Auto-generated method stub
		return leaguesummonersdao.findBySummonersid(param7);
	}




	
}
