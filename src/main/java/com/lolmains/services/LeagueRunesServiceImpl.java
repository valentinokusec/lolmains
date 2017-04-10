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
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoners;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.LeagueRunesDao;
import com.lolmains.repository.LeagueSummonersDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.SummonersDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;



@Service
public class LeagueRunesServiceImpl implements LeagueRunesService {
	

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";
	
	
	@Autowired
	 LeagueRunesDao  leaguerunesdao;


	@Override
	public List<LeagueRunes> getAll() {
		// TODO Auto-generated method stub
		return leaguerunesdao.findAll();
	}



	@Override
	public LeagueRunes addAll() {
		// TODO Auto-generated method stub
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		List<com.robrua.orianna.type.core.staticdata.Rune> itemList=RiotAPI.getRunes();
		for (com.robrua.orianna.type.core.staticdata.Rune rune:itemList) {
			try {
				LeagueRunes ls=new LeagueRunes(rune.getID(), 3, rune.getDescription(), rune.getName(),rune.getImage().getFull(),rune.getDepth());
				leaguerunesdao.save(ls);
			} catch (Exception e) {
				System.out.println(rune.getID());
			}
		}
		return null;
	}



	@Override
	public LeagueRunes addLeagueRunes(LeagueRunes LeagueRunes) {
		// TODO Auto-generated method stub
		return leaguerunesdao.save(LeagueRunes);
	}



	@Override
	public LeagueRunes findLeagueRunes(int id) {
		// TODO Auto-generated method stub
		return leaguerunesdao.findOne(id);
	}



	@Override
	public List<LeagueRunes> findByNameIgnoreCaseContaining(String data) {
		// TODO Auto-generated method stub
		return leaguerunesdao.findByNameIgnoreCaseContaining(data);
	}



	@Override
	public LeagueRunes findByRuneid(int id) {
		// TODO Auto-generated method stub
		return leaguerunesdao.findByRuneid(id);
	}




	
}
